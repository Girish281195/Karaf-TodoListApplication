

function controllerFunction($scope,$http){

   /* $scope.message = "This is a test for todo app";
    $http.get("http://localhost:8181/cxf/rest/todos")
        .success(function(data){
                        $scope.message=null;
                        $scope.todoList = data.todo;
                   }
                 );*/
    var getListOfTodos = function(){
            $http.get("http://localhost:8181/cxf/rest/todos")
                                                    .success(function(data){
                                                                    $scope.message=null;
                                                                    $scope.todoList = data.todo;
                                                               }
                                                             );
    }

    getListOfTodos();

    $scope.addTodoFunction = function(){
        $http.post("http://localhost:8181/cxf/rest/todos", {"todo":[{"todoName":$scope.name, "todoDescription":$scope.description, "todoStatus":$scope.status}]})
        .success(function(result){
                $scope.name='';
                $scope.description='';
                $scope.status='';
                /*alert("Todo added successfully");*/
                getListOfTodos();
        }).error(function(response){
            alert("Failed to add Todo");
        });
    }

    $scope.deleteTodoFunction = function(todoId){
        $http.delete("http://localhost:8181/cxf/rest/todos/" +todoId).success(function(response){
            /*alert("Todo Deleted");*/
            getListOfTodos();
        });
    }

    $scope.updateTodo = function(todoId){
        $http.put("http://localhost:8181/cxf/rest/todos", {"todo":{"todoId": $scope.id, "todoName":$scope.name, "todoDescription":$scope.description, "todoStatus":$scope.status}})
        .success(function(response){
            getListOfTodos();
            /*alert("Todo Updated");*/
        })

    }

    $scope.updateStatus = function(id, name, description){
        $http.put("http://localhost:8181/cxf/rest/todos", {"todo":{"todoId": id, "todoName":name, "todoDescription":description, "todoStatus":"Complete"}})
        .success(function(response){
        /*alert("Marked as completed")*/
            getListOfTodos();
        });
    }

    $scope.deleteAllTodo = function(){
            $http.delete("http://localhost:8181/cxf/rest/todos/").success(function(response){
                getListOfTodos();
                /*alert("Todos Deleted");*/
            });
        }
};

var app = angular.module("Angular-App",["ngResource"]);
app.controller("Angular-Controller",controllerFunction);
