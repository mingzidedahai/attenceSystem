'use strict';
// 处理前后端数据交互的
var services = angular.module('guthub.services', [ 'ngResource' ]);
// +++++++++++++++++++userfile+++++++++++++++++++++++
services.factory('UserFile', [ '$resource', function($resource) {
	return $resource('/attenceSystem/services/UserFiles/:id', {
		id : '@id'
	});
} ]);
services.factory('BMUserFile', [ '$resource', function($resource) {
	return $resource('/attenceSystem/services/UserFiles/BM', {
		id : '@id'
	});
} ]);
services.factory('FZUserFile', [ '$resource', function($resource) {
	return $resource('/attenceSystem/services/UserFiles/FZ', {
		id : '@id'
	});
} ]);
services.factory('ZUserFile', [ '$resource', function($resource) {
	return $resource('/attenceSystem/services/UserFiles/Z', {
		id : '@id'
	});
} ]);

services.factory('MeUserFileLoader', [
		'UserFile',
		'$route',
		'$q',
		function(UserFile, $route, $q) {
			return function() {
				console.log("Meuserfileloader begtin");
				var delay = $q.defer();
				UserFile.get({
					id : getCookie('USER_CONTEXT')
				}, function(userFile) {
					delay.resolve(userFile);
					
				}, function() {
					delay.reject('Unable to fetc Meuserfile '
							+ $route.current.params.userfielId);
					console.log("Meu2urn");
				});
				console.log(UserFile);
				return delay.promise;
			};
		} ]);

services.factory('MultiUserFileLoader', [ 'UserFile', '$q',
		function(UserFile, $q) {
			return function() {
				var delay = $q.defer();
				UserFile.query(function(userFiles) {
					delay.resolve(userFiles);
				}, function() {
					delay.reject('Unable to fetch userFiles');
				});
				return delay.promise;
			};
		} ]);
services.factory('BMMultiUserFileLoader', [ 'BMUserFile', '$q',
		function(BMUserFile, $q) {
			return function() {
				var delay = $q.defer();
				BMUserFile.query(function(BMuserFiles) {
					delay.resolve(BMuserFiles);
				}, function() {
					delay.reject('Unable to fetch userFiles');
				});
				return delay.promise;
			};
		} ]);
services.factory('FZMultiUserFileLoader', [ 'FZUserFile', '$q',
		function(FZUserFile, $q) {
			return function() {
				var delay = $q.defer();
				FZUserFile.query(function(FZuserFiles) {
					delay.resolve(FZuserFiles);
				}, function() {
					delay.reject('Unable to fetch userFiles');
				});
				return delay.promise;
			};
		} ]);
services.factory('ZMultiUserFileLoader', [ 'ZUserFile', '$q',
		function(ZUserFile, $q) {
			return function() {
				var delay = $q.defer();
				ZUserFile.query(function(ZuserFiles) {
					delay.resolve(ZuserFiles);
				}, function() {
					delay.reject('Unable to fetch userFiles');
				});
				return delay.promise;
			};
		} ]);
// ------------------------userfile-----------------------
// +++++++++++++++++++++++++++leave++++++++++++++++++++++++
services.factory('LeaveApprvols', [ '$resource', function($resource) {
	console.log("MeMultiLeaveApproalLoader");
	return $resource('/attenceSystem/services/Leaves/me/leaveapprovals/:userfileid', {
		userfileid : getCookie('USER_CONTEXT')
	});
} ]);
services.factory('Leave', [ '$resource', function($resource) {
	return $resource('/attenceSystem/services/Leaves/:id', {
		id : '@id'
	});
} ]);

services.factory('Leaves', [ '$resource', function($resource) {
	
	return $resource('/attenceSystem/services/Leaves/me/:userfileid', {
		userfileid : getCookie('USER_CONTEXT')
	});
} ]);

services.factory('MeMultiLeaveLoader', [ 'Leaves', '$q', function(Leaves, $q) {
	return function() {
		console.log("multievectionsloader");
		var delay = $q.defer();
		Leaves.query(function(leaves) {
			delay.resolve(leaves);
		}, function() {
			delay.reject('Unable to fetch leaves');
		});
		return delay.promise;
	};
} ]);
services.factory('MeMultiLeaveApproalLoader', [ 'LeaveApprvols', '$q', function(LeaveApprvols, $q) {
	return function() {
		console.log("MeMultiLeaveApproalLoader");
		var delay = $q.defer();
		LeaveApprvols.query(function(leaveapprovals) {//事实上返回的是Leave
			delay.resolve(leaveapprovals);
		}, function() {
			delay.reject('Unable to fetch MeMultiLeaveApproalLoader');
		});
		return delay.promise;
	};
} ]);
services.factory('MultiLeaveLoader', [ 'Leave', '$q', function(Leave, $q) {
	return function() {
		var delay = $q.defer();
		Leave.query(function(leaves) {
			delay.resolve(leaves);
		}, function() {
			delay.reject('Unable to fetch evections');
		});
		return delay.promise;
	};
} ]);

services.factory('LeaveLoader', [
		'Leave',
		'$route',
		'$q',
		function(Leave, $route, $q) {
			return function() {
				var delay = $q.defer();
				Leave.get({
					id : $route.current.params.leaveId
				}, function(leave) {
					delay.resolve(leave);
				}, function() {
					delay.reject('Unable to fetch leave '
							+ $route.current.params.leaveId);
				});
				return delay.promise;
			};
		} ]);

// ---------------------------leave------------------------
//+++++++++++++++++++++++++++evection++++++++++++++++++++++++
services.factory('EvectionApprvols', [ '$resource', function($resource) {
	console.log("MeMultiEvectionApproalLoader");
	return $resource('/attenceSystem/services/Evections/me/evectionapprovals/:userfileid', {
		userfileid : getCookie('USER_CONTEXT')
	});
} ]);
services.factory('Evection', [ '$resource', function($resource) {
	return $resource('/attenceSystem/services/Evections/:id', {
		id : '@id'
	});
} ]);
services.factory('Evections', [ '$resource', function($resource) {
	
	return $resource('/attenceSystem/services/Evections/me/:userfileid', {
		userfileid : getCookie('USER_CONTEXT')
	});
} ]);

services.factory('MeMultiEvectionLoader', [ 'Evections', '$q', function(Evections, $q) {
	return function() {
		console.log("multievectionsloader");
		var delay = $q.defer();
		Evections.query(function(evections) {
			delay.resolve(evections);
		}, function() {
			delay.reject('Unable to fetch evections');
		});
		return delay.promise;
	};
} ]);
services.factory('MeMultiEvectionApproalLoader', [ 'EvectionApprvols', '$q', function(EvectionApprvols, $q) {
	return function() {
		console.log("MeMultiEvectionApproalLoader");
		var delay = $q.defer();
		EvectionApprvols.query(function(evectionapprovals) {//事实上返回的是Evection
			delay.resolve(evectionapprovals);
		}, function() {
			delay.reject('Unable to fetch MeMultiEvectionApproalLoader');
		});
		return delay.promise;
	};
} ]);
services.factory('MultiEvectionLoader', [ 'Evection', '$q', function(Evection, $q) {
	return function() {
		var delay = $q.defer();
		Evection.query(function(evections) {
			delay.resolve(evections);
		}, function() {
			delay.reject('Unable to fetch evections');
		});
		return delay.promise;
	};
} ]);

services.factory('EvectionLoader', [
		'Evection',
		'$route',
		'$q',
		function(Evection, $route, $q) {
			return function() {
				var delay = $q.defer();
				Evection.get({
					id : $route.current.params.evectionId
				}, function(evection) {
					delay.resolve(evection);
				}, function() {
					delay.reject('Unable to fetch evection '
							+ $route.current.params.evectionId);
				});
				return delay.promise;
			};
		} ]);

// ---------------------------evection------------------------
//+++++++++++++++++++++++++++punch++++++++++++++++++++++++

services.factory('Punch', [ '$resource', function($resource) {
	return $resource('/attenceSystem/services/Punchs/:id', {
		id : '@id'
	});
} ]);
services.factory('Punchs', [ '$resource', function($resource) {
	
	return $resource('/attenceSystem/services/Punchs/me/:userfileid', {
		userfileid : getCookie('USER_CONTEXT')
	});
} ]);

services.factory('MeMultiPunchLoader', [ 'Punchs', '$q', function(Punchs, $q) {
	return function() {
		console.log("multipunchsloader");
		var delay = $q.defer();
		Punchs.query(function(punchs) {
		
			delay.resolve(punchs);
		}, function() {
			delay.reject('Unable to fetch punchs');
		});
		
		return delay.promise;
	};
} ]);

services.factory('MultiPunchLoader', [ 'Punch', '$q', function(Punch, $q) {
	return function() {
		var delay = $q.defer();
		Punch.query(function(punchs) {
			delay.resolve(punchs);
		}, function() {
			delay.reject('Unable to fetch punchs');
		});
		return delay.promise;
	};
} ]);

services.factory('PunchLoader', [
		'Punch',
		'$route',
		'$q',
		function(Punch, $route, $q) {
			return function() {
				var delay = $q.defer();
				Punch.get({
					id : $route.current.params.punchId
				}, function(punch) {
					delay.resolve(punch);
				}, function() {
					delay.reject('Unable to fetch punch '
							+ $route.current.params.punchId);
				});
				return delay.promise;
			};
		} ]);

// ---------------------------punch------------------------
// +++++++++++++++++++++++++++recipe+++++++++++++++++++++++
services.factory('RecipeLoader', [
		'Recipe',
		'$route',
		'$q',
		function(Recipe, $route, $q) {
			return function() {
				var delay = $q.defer();
				Recipe.get({
					id : $route.current.params.recipeId
				}, function(recipe) {
					delay.resolve(recipe);
				}, function() {
					delay.reject('Unable to fetch recipe '
							+ $route.current.params.recipeId);
				});
				return delay.promise;
			};
		} ]);

app.controller('NewCtrl', [ '$scope', '$location', 'Recipe',
		function($scope, $location, Recipe) {
			$scope.recipe = new Recipe({
				ingredients : [ {} ]
			});

			$scope.save = function() {
				$scope.recipe.$save(function(recipe) {
					$location.path('/');
				});
			};
		} ]);

app.controller('IngredientsCtrl', [ '$scope', function($scope) {
	$scope.addIngredient = function() {
		var ingredients = $scope.recipe.ingredients;
		ingredients[ingredients.length] = {};
	};
	$scope.removeIngredient = function(index) {
		$scope.recipe.ingredients.splice(index, 1);
	};
} ]);
// -----------------------------recipe------------------------
// +++++++++++++++++++++++++++++++cookie++++++++++++++++++++++
function getCookie(c_name) {
	if (document.cookie.length > 0) {
		c_start = document.cookie.indexOf(c_name + "=");
		if (c_start != -1) {
			c_start = c_start + c_name.length + 1;
			c_end = document.cookie.indexOf(";", c_start);
			if (c_end == -1)
				c_end = document.cookie.length;
			return unescape(document.cookie.substring(c_start, c_end));
		}
	}
	return "";
}

function setCookie(c_name, value, expiredays) {
	var exdate = new Date();
	exdate.setDate(exdate.getDate() + expiredays);
	document.cookie = c_name + "=" + escape(value)
			+ ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString());
}

// -------------------------------cookie-------------------------
