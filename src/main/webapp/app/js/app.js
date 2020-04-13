'use strict';
var covid = angular.module('covid', [ 'ui.router' ]);
covid.config(function($stateProvider, $urlRouterProvider) {
	
	$urlRouterProvider.otherwise('country-dashboard');
	$stateProvider.state('world-dashboard',{
		url : '/world-dashboard',
		templateUrl : 'views/world-dashboard.html',
		controller : 'world-dashboardCtrl'
	})
	.state('country-dashboard',{
		url : '/country-dashboard',
		templateUrl : 'views/country-dashboard.html',
		controller : 'country-dashboardCtrl'
	})
	.state('add-countryRecords',{
		url : '/add-countryRecords',
		templateUrl : 'views/add-countryRecords.html',
		controller : 'add-countryRecordsCtrl'
	})
	.state('add-worldRecords',{
    		url : '/add-worldRecords',
    		templateUrl : 'views/add-worldRecords.html',
    		controller : 'add-worldRecordsCtrl'
    	})
});

covid.controller('world-dashboardCtrl', [ '$scope','$http',
	function($scope, $http) {
		console.log('world-dashboardCtrl');
		$scope.getAllWorldRecords = function() {
			var responsePromise = $http.get("http://localhost:8080/covid/rest/covid/getAllRecords");
			responsePromise.then(successCallback, errorCallback);
			function successCallback(response) {
				if (response.status === 200) {
					$scope.WorldRecords = response.data.Records;
					console.log($scope.WorldRecords);
				}
			}
			function errorCallback(error) {
					$window.alert(JSON.stringify(error.data.Error[0].Message));
			}
		}
		$scope.getAllWorldRecords();
		$scope.submit = function() {
                	console.log('submit function');
                		var country=$scope.country;
                		var responsePromise = $http.get("http://localhost:8080/covid/rest/covid/getRecordsByCountry?country="+country);
                		responsePromise.then(successCallback, errorCallback);
                		function successCallback(response) {
                			if (response.status=== 200) {
                				$scope.WorldRecords = response.data.Records;
                				console.log($scope.WorldRecords);
                			}
                		}
                		function errorCallback(error) {
                				$window.alert(JSON.stringify(error.data.Error[0].Message));
                		}
                	}

}]);

covid.controller('country-dashboardCtrl', [ '$scope','$http',
	function($scope, $http) {
		console.log('country-dashboardCtrl');
		$scope.getAllCountryRecords = function() {
		console.log('getAllCountryRecords function');
			var responsePromise = $http.get("http://localhost:8080/covid19/api/jpa/getAllRecordDetails");
			responsePromise.then(successCallback, errorCallback);
			function successCallback(response) {
				if (response.status=== 200) {
					$scope.CountryRecords = response.data.recordsObject;
					console.log($scope.CountryRecords);
				}
			}
			function errorCallback(error) {
					$window.alert(JSON.stringify(error.data.Error[0].Message));
			}
		}
		$scope.getAllCountryRecords();
		$scope.submit = function() {
        	console.log('submit function');
        		var state=$scope.state;
        		var responsePromise = $http.get("http://localhost:8080/covid19/api/jpa/getRecordDetailsByState?state="+state);
        		responsePromise.then(successCallback, errorCallback);
        		function successCallback(response) {
        			if (response.status=== 200) {
        				$scope.CountryRecords = response.data.recordsObject;
        				console.log($scope.CountryRecords);
        			}
        		}
        		function errorCallback(error) {
        				$window.alert(JSON.stringify(error.data.Error[0].Message));
        		}
        	}

}]);

covid.controller('add-countryRecordsCtrl', [ '$scope','$http',
	function($scope, $http) {
	$scope.submit=function(){
		var responsePromise = $http.post("http://localhost:8080/covid19/api/jpa/addRecordsDetails",$scope.record,{
			headers : {
				'Content-Type' : 'application/json'
			},
		});
		responsePromise.then(successCallback);
		function successCallback(response) {
        if (response.status === 200)
				alert("data inserted");

		}
		function errorCallback(error) {
           alert(JSON.stringify(error.data.Error[0].Message));
        }
	}
}]);

covid.controller('add-worldRecordsCtrl', [ '$scope','$http',
	function($scope, $http) {
	$scope.submit=function(){
		var responsePromise = $http.post("http://localhost:8080/covid/rest/covid/addRecords",$scope.record,{
			headers : {
				'Content-Type' : 'application/json'
			},
		});
		responsePromise.then(successCallback);
		function successCallback(response) {
        if (response.status === 200)
				alert("data inserted");
			}
		function errorCallback(error) {
        		$window.alert(JSON.stringify(error.data.Error[0].Message));
        	}
	}
}]);
