'use strict';
// 单页面应用

var app = angular.module('guthub', [ 'guthub.directives', 'guthub.services' ]);
// +++++++++++++route config+++++++++++++++
app
		.config([
				'$routeProvider',
				function($routeProvider) {
					$routeProvider
							.when('/', {
								controller : 'NewCtrl',
								templateUrl : 'views/help.html'
							})
							.when(
									'/home',
									{
										controller : 'Home',// 页面使用的controller
										resolve : {// 提前准备数据
											recipes : [
													"MultiUserFileLoader",
													function(
															MultiUserFileLoader) {
														return MultiUserFileLoader();
													} ]
										},
										templateUrl : 'views/help.html'// 路由到的位置
									})

							.when(
									'/view/:recipeId',
									{
										controller : 'ViewCtrl',
										resolve : {
											recipe : [ "RecipeLoader",
													function(RecipeLoader) {
														return RecipeLoader();
													} ]
										},
										templateUrl : 'views/viewRecipe.html'
									})
							.when('/new', {
								controller : 'NewCtrl',
								templateUrl : 'views/recipeForm.html'
							})
							.when('/haha', {
								controller : 'NewCtrl',
								templateUrl : 'views/1.html'
							})
							.when('/life', {
								controller : 'NewCtrl',
								templateUrl : 'views/234.html'
							// +++++++++++++++++++++++++++++leave
							// route+++++++++++++++++++++++
							})
							.when(
									'/me/leaves',
									{
										controller : 'MeLeaves',
										resolve : {
											leaves : [
													"MeMultiLeaveLoader",
													function(MeMultiLeaveLoader) {

														return MeMultiLeaveLoader();
													} ]
										},
										templateUrl : 'views/qList.html'
									})
							.when(
									'/newLeave',
									{
										controller : 'NewLeave',
										resolve : {

											meuserfile : [
													"MeUserFileLoader",
													function(MeUserFileLoader) {

														return MeUserFileLoader();
													} ],
											BMuserfiles : [
													"BMMultiUserFileLoader",
													function(
															BMMultiUserFileLoader) {

														return BMMultiUserFileLoader();
													} ],
											FZuserfiles : [
													"FZMultiUserFileLoader",
													function(
															FZMultiUserFileLoader) {

														return FZMultiUserFileLoader();
													} ],
											Zuserfiles : [
													"ZMultiUserFileLoader",
													function(
															ZMultiUserFileLoader) {

														return ZMultiUserFileLoader();
													} ]

										},

										templateUrl : 'views/qForm.html'
									})
							.when(
									'/me/leaveapprovals',
									{
										controller : 'MeLeaveApproals',
										resolve : {

											meuserfile : [
													"MeUserFileLoader",
													function(MeUserFileLoader) {

														return MeUserFileLoader();
													} ],
											leaves : [
													"MeMultiLeaveApproalLoader",
													function(
															MeMultiLeaveApproalLoader) {
														console
																.log("loda  MeMultiLeaveApproalLoader");
														return MeMultiLeaveApproalLoader();
													} ]
										},
										templateUrl : 'views/qApproval.html'
									})
							.when(
									'/edit/:leaveId',
									{
										controller : 'EditLeave',
										resolve : {
											BMuserfiles : [
													"BMMultiUserFileLoader",
													function(
															BMMultiUserFileLoader) {

														return BMMultiUserFileLoader();
													} ],
											FZuserfiles : [
													"FZMultiUserFileLoader",
													function(
															FZMultiUserFileLoader) {

														return FZMultiUserFileLoader();
													} ],
											Zuserfiles : [
													"ZMultiUserFileLoader",
													function(
															ZMultiUserFileLoader) {

														return ZMultiUserFileLoader();
													} ],
											meuserfile : [
													"MeUserFileLoader",
													function(MeUserFileLoader) {

														return MeUserFileLoader();
													} ],
											leave : [ "LeaveLoader",
													function(LeaveLoader) {
														return LeaveLoader();
													} ]
										},
										templateUrl : 'views/qForm.html'

									// ------------------------leave
									// route--------------------
									// +++++++++++++++++++++++++++++evection
									// route+++++++++++++++++++++++
									})
							.when(
									'/me/evections',
									{
										controller : 'MeEvections',
										resolve : {
											evections : [
													"MeMultiEvectionLoader",
													function(
															MeMultiEvectionLoader) {

														return MeMultiEvectionLoader();
													} ]
										},
										templateUrl : 'views/wList.html'
									})
							.when(
									'/newEvection',
									{
										controller : 'NewEvection',
										resolve : {

											meuserfile : [
													"MeUserFileLoader",
													function(MeUserFileLoader) {

														return MeUserFileLoader();
													} ],
											BMuserfiles : [
													"BMMultiUserFileLoader",
													function(
															BMMultiUserFileLoader) {

														return BMMultiUserFileLoader();
													} ],
											FZuserfiles : [
													"FZMultiUserFileLoader",
													function(
															FZMultiUserFileLoader) {

														return FZMultiUserFileLoader();
													} ],
											Zuserfiles : [
													"ZMultiUserFileLoader",
													function(
															ZMultiUserFileLoader) {

														return ZMultiUserFileLoader();
													} ]

										},

										templateUrl : 'views/wForm.html'
									})
							.when(
									'/me/evectionapprovals',
									{
										controller : 'MeEvectionApproals',
										resolve : {

											meuserfile : [
													"MeUserFileLoader",
													function(MeUserFileLoader) {

														return MeUserFileLoader();
													} ],
											evections : [
													"MeMultiEvectionApproalLoader",
													function(
															MeMultiEvectionApproalLoader) {
														console
																.log("loda  MeMultiEvectionApproalLoader");
														return MeMultiEvectionApproalLoader();
													} ]
										},
										templateUrl : 'views/wApproval.html'
									})
							.when(
									'/edit/:evectionId',
									{
										controller : 'EditEvection',
										resolve : {
											BMuserfiles : [
													"BMMultiUserFileLoader",
													function(
															BMMultiUserFileLoader) {

														return BMMultiUserFileLoader();
													} ],
											FZuserfiles : [
													"FZMultiUserFileLoader",
													function(
															FZMultiUserFileLoader) {

														return FZMultiUserFileLoader();
													} ],
											Zuserfiles : [
													"ZMultiUserFileLoader",
													function(
															ZMultiUserFileLoader) {

														return ZMultiUserFileLoader();
													} ],
											meuserfile : [
													"MeUserFileLoader",
													function(MeUserFileLoader) {

														return MeUserFileLoader();
													} ],
											evection : [
													"EvectionLoader",
													function(EvectionLoader) {
														return EvectionLoader();
													} ]
										},
										templateUrl : 'views/wForm.html'

									// ------------------------evection
									// route--------------------
									// +++++++++++++++++++++++++++++punch
									// route+++++++++++++++++++++++
									})
							.when(
									'/me/punchs',
									{
										controller : 'MePunchs',
										resolve : {
											punchs : [
													"MeMultiPunchLoader",
													function(MeMultiPunchLoader) {

														return MeMultiPunchLoader();
													} ]
										},
										templateUrl : 'views/punchRecord.html'
									})
							.when(
									'/punchs',
									{
										controller : 'Punchs',
										resolve : {
											punchs : [
													"MultiPunchLoader",
													function(MultiPunchLoader) {

														return MultiPunchLoader();
													} ]
										},
										templateUrl : 'views/punchRecord.html'
									})
							// ------------------------punch
							// route--------------------
							// ++++++++++++++++++++++++++allList+++++++++++++++++++
							.when(
									'/allList',
									{
										controller : 'AllList',
										resolve : {

											leaves : [
													"MultiLeaveLoader",
													function(MultiLeaveLoader) {
                                                       
														return MultiLeaveLoader();
													} ],
											evections : [
													"MultiEvectionLoader",
													function(MultiEvectionLoader) {

														return MultiEvectionLoader();
													} ]

										},
										templateUrl : 'views/allList.html'
									})
							// -------------------------allList-------------------
							.when('/wForm', {
								controller : 'NewCtrl',
								templateUrl : 'views/wForm.html'
							}).when('/wList', {
								controller : 'NewCtrl',
								templateUrl : 'views/wList.html'
							}).when('/punchRecord', {
								controller : 'NewCtrl',
								templateUrl : 'views/punchRecord.html'
							}).when('/xLookCard', {
								controller : 'NewCtrl',
								templateUrl : 'views/xLookCard.html'
							}).when('/xLookLeave', {
								controller : 'NewCtrl',
								templateUrl : 'views/xLookLeave.html'
							}).when('/test', {
								controller : 'NewCtrl',
								templateUrl : 'views/test.html'
							}).when('/xLookLeaveDetail', {
								controller : 'NewCtrl',
								templateUrl : 'views/xLookLeaveDetail.html'
							}).when('/xYearVacation', {
								controller : 'NewCtrl',
								templateUrl : 'views/xYearVacation.html'
							}).otherwise({
								redirectTo : '/'
							});
				} ]);
// ---------------------------route config---------------------
// ++++++++++++++++++++leave controller+++++++++++++++++++
app.controller('MeLeaves', [ '$scope', 'leaves', function($scope, leaves) {
	$scope.numberone = 0;
	$scope.leaves = leaves;
	// $scope.remove = function() { //删除未实现
	// delete $scope.leave;
	// $location.path('/me/leaves');
	// };
} ]);
app.controller('MeLeaveApproals', [ '$scope', 'leaves', 'meuserfile',
		function($scope, leaves, meuserfile) {
			$scope.leaves = leaves;
			$scope.meuserfile = meuserfile;
			// 本来应该但save某个批准，此地有冗余
			$scope.save = function() {
				$scope.leaves.$save(function(leaves) {
					$location.path('/');
				});
			};

		} ]);
app.controller('NewLeave', [
		'$scope',
		'$location',
		'meuserfile',
		'BMuserfiles',
		'FZuserfiles',
		'Zuserfiles',
		'Leave',

		function($scope, $location, meuserfile, BMuserfiles, FZuserfiles,
				Zuserfiles, Leave) {
			$scope.meuserfile = meuserfile;
			$scope.bmuserfiles = BMuserfiles;
			$scope.fzuserfiles = FZuserfiles;
			$scope.zuserfiles = Zuserfiles;

			$scope.leave = new Leave({

				leaveApprovals : [ {
					"agree" : "审批中"
				}, {
					"agree" : "审批中"
				}, {
					"agree" : "审批中",
					"userfileid" : 0
				} ],
				userfileid : meuserfile.id,
				state : "审批中"
			});

			$scope.save = function() {
				$scope.leave.$save(function(leave) {
					$location.path('/#/me/leaves');
				});
			};

			$('.starttime').datetimepicker({
				format : 'yyyy/mm/dd-hh',
				minView : 1,
				startDate : new Date(),
				weekStart : 1,
				todayBtn : 1,
				autoclose : 1,
				todayHighlight : 1,
				startView : 2,
				forceParse : 0,
				showMeridian : 1
			}).on(
					'changeDate',
					function(ev) {
						$scope.leave.startTime = (ev.date.getYear() + 1900)
								+ "/" + (ev.date.getMonth() + 1) + "/"
								+ (ev.date.getDate()) + "-"
								+ (ev.date.getHours());
						// var d=ev.date;
						// $scope.leave.startTime=d.subString(0,3);
					});
			$('.endtime').datetimepicker({
				format : 'yyyy/mm/dd-hh',
				minView : 1,
				startDate : new Date(),
				weekStart : 1,
				todayBtn : 1,
				autoclose : 1,
				todayHighlight : 1,
				startView : 2,
				forceParse : 0,
				showMeridian : 1
			}).on(
					'changeDate',
					function(ev) {
						$scope.leave.endTime = (ev.date.getYear() + 1900) + "/"
								+ (ev.date.getMonth() + 1) + "/"
								+ (ev.date.getDate()) + "-"
								+ (ev.date.getHours());

					});

		} ]);
app.controller('NewLeaveApproval', [ '$scope', function($scope) {
	$scope.newLeaveApproval = function() {
		var leaveApprovals = $scope.leave.leaveApprovals;
		leaveApprovals[leaveApprovals.length] = {};
	};
	$scope.removeLeaveApproval = function(index) {
		$scope.leave.leaveApprovals.splice(index, 1);
	};
} ]);
app.controller('EditLeave', [
		'$scope',
		'$location',
		'leave',
		'meuserfile',
		'BMuserfiles',
		'FZuserfiles',
		'Zuserfiles',
		function($scope, $location, leave, meuserfile, BMuserfiles,
				FZuserfiles, Zuserfiles) {
			$scope.leave = leave;
			$scope.meuserfile = meuserfile;
			$scope.bmuserfiles = BMuserfiles;
			$scope.fzuserfiles = FZuserfiles;
			$scope.zuserfiles = Zuserfiles;
			$scope.save = function() {
				$scope.leave.$save(function(leave) {// $scope下的变量继承$resource。参照restful接口的命名，具有get
					// query remove save等功能
					$location.path('/me/leaves');
				});
			};

			$scope.remove = function() {
				delete $scope.leave;
				$location.path('/me/leaves');
			};
			$('.starttime').datetimepicker({
				format : 'yyyy/mm/dd-hh',
				minView : 1,
				startDate : new Date(),
				weekStart : 1,
				todayBtn : 1,
				autoclose : 1,
				todayHighlight : 1,
				startView : 2,
				forceParse : 0,
				showMeridian : 1
			}).on(
					'changeDate',
					function(ev) {
						$scope.leave.startTime = (ev.date.getYear() + 1900)
								+ "/" + (ev.date.getMonth() + 1) + "/"
								+ (ev.date.getDate()) + "-"
								+ (ev.date.getHours());
						// var d=ev.date;
						// $scope.leave.startTime=d.subString(0,3);
					});
			$('.endtime').datetimepicker({
				format : 'yyyy/mm/dd-hh',
				minView : 1,
				startDate : new Date(),
				weekStart : 1,
				todayBtn : 1,
				autoclose : 1,
				todayHighlight : 1,
				startView : 2,
				forceParse : 0,
				showMeridian : 1
			}).on(
					'changeDate',
					function(ev) {
						$scope.leave.endTime = (ev.date.getYear() + 1900) + "/"
								+ (ev.date.getMonth() + 1) + "/"
								+ (ev.date.getDate()) + "-"
								+ (ev.date.getHours());

					});
		} ]);


// ---------------------leave controller------------------------
// ++++++++++++++++++++evection controller+++++++++++++++++++
app.controller('MeEvections', [ '$scope', 'evections',
		function($scope, evections) {
			$scope.numberone = 0;
			$scope.evections = evections;
			// $scope.remove = function() { //删除未实现
			// delete $scope.evection;
			// $location.path('/me/evections');
			// };
		} ]);
app.controller('MeEvectionApproals', [ '$scope', 'evections', 'meuserfile',
		function($scope, evections, meuserfile) {
			$scope.evections = evections;
			$scope.meuserfile = meuserfile;
			// 本来应该但save某个批准，此地有冗余
			$scope.save = function() {
				$scope.evections.$save(function(evections) {
					$location.path('/');
				});
			};

		} ]);
app.controller('NewEvection', [
		'$scope',
		'$location',
		'meuserfile',
		'BMuserfiles',
		'FZuserfiles',
		'Zuserfiles',
		'Evection',

		function($scope, $location, meuserfile, BMuserfiles, FZuserfiles,
				Zuserfiles, Evection) {
			$scope.meuserfile = meuserfile;
			$scope.bmuserfiles = BMuserfiles;
			$scope.fzuserfiles = FZuserfiles;
			$scope.zuserfiles = Zuserfiles;

			$scope.evection = new Evection({

				evectionApprovals : [ {
					"agree" : "审批中"
				}, {
					"agree" : "审批中"
				}, {
					"agree" : "审批中",
					"userfileid" : 0
				} ],
				userfileid : meuserfile.id,
				state : "审批中"
			});

			$scope.save = function() {
				$scope.evection.$save(function(evection) {
					$location.path('/#/me/evections');
				});
			};

			$('.starttime').datetimepicker({
				format : 'yyyy/mm/dd-hh',
				minView : 1,
				startDate : new Date(),
				weekStart : 1,
				todayBtn : 1,
				autoclose : 1,
				todayHighlight : 1,
				startView : 2,
				forceParse : 0,
				showMeridian : 1
			}).on(
					'changeDate',
					function(ev) {
						$scope.evection.startTime = (ev.date.getYear() + 1900)
								+ "/" + (ev.date.getMonth() + 1) + "/"
								+ (ev.date.getDate()) + "-"
								+ (ev.date.getHours());
						// var d=ev.date;
						// $scope.evection.startTime=d.subString(0,3);
					});
			$('.endtime').datetimepicker({
				format : 'yyyy/mm/dd-hh',
				minView : 1,
				startDate : new Date(),
				weekStart : 1,
				todayBtn : 1,
				autoclose : 1,
				todayHighlight : 1,
				startView : 2,
				forceParse : 0,
				showMeridian : 1
			}).on(
					'changeDate',
					function(ev) {
						$scope.evection.endTime = (ev.date.getYear() + 1900)
								+ "/" + (ev.date.getMonth() + 1) + "/"
								+ (ev.date.getDate()) + "-"
								+ (ev.date.getHours());

					});

		} ]);
app.controller('NewEvectionApproval', [ '$scope', function($scope) {
	$scope.newEvectionApproval = function() {
		var evectionApprovals = $scope.evection.evectionApprovals;
		evectionApprovals[evectionApprovals.length] = {};
	};
	$scope.removeEvectionApproval = function(index) {
		$scope.evection.evectionApprovals.splice(index, 1);
	};
} ]);
app.controller('EditEvection', [
		'$scope',
		'$location',
		'evection',
		'meuserfile',
		'BMuserfiles',
		'FZuserfiles',
		'Zuserfiles',
		function($scope, $location, evection, meuserfile, BMuserfiles,
				FZuserfiles, Zuserfiles) {
			$scope.evection = evection;
			$scope.meuserfile = meuserfile;
			$scope.bmuserfiles = BMuserfiles;
			$scope.fzuserfiles = FZuserfiles;
			$scope.zuserfiles = Zuserfiles;
			$scope.save = function() {
				$scope.evection.$save(function(evection) {// $scope下的变量继承$resource。参照restful接口的命名，具有get
					// query remove save等功能
					$location.path('/me/evections');
				});
			};

			$scope.remove = function() {
				delete $scope.evection;
				$location.path('/me/evections');
			};
			$('.starttime').datetimepicker({
				format : 'yyyy/mm/dd-hh',
				minView : 1,
				startDate : new Date(),
				weekStart : 1,
				todayBtn : 1,
				autoclose : 1,
				todayHighlight : 1,
				startView : 2,
				forceParse : 0,
				showMeridian : 1
			}).on(
					'changeDate',
					function(ev) {
						$scope.evection.startTime = (ev.date.getYear() + 1900)
								+ "/" + (ev.date.getMonth() + 1) + "/"
								+ (ev.date.getDate()) + "-"
								+ (ev.date.getHours());
						// var d=ev.date;
						// $scope.evection.startTime=d.subString(0,3);
					});
			$('.endtime').datetimepicker({
				format : 'yyyy/mm/dd-hh',
				minView : 1,
				startDate : new Date(),
				weekStart : 1,
				todayBtn : 1,
				autoclose : 1,
				todayHighlight : 1,
				startView : 2,
				forceParse : 0,
				showMeridian : 1
			}).on(
					'changeDate',
					function(ev) {
						$scope.evection.endTime = (ev.date.getYear() + 1900)
								+ "/" + (ev.date.getMonth() + 1) + "/"
								+ (ev.date.getDate()) + "-"
								+ (ev.date.getHours());

					});
		} ]);

// ---------------------evection controller------------------------
// ++++++++++++++++++++punch controller+++++++++++++++++++
app.controller('MePunchs', [ '$scope', 'punchs', function($scope, punchs) {
	console.log("controller");
	console.log(punchs);
	var a = 0;
	$scope.a = 0;

	$scope.punchs = punchs;
	console.log(punchs);
	// $scope.remove = function() { //删除未实现
	// delete $scope.punch;
	// $location.path('/me/punchs');
	// };
} ]);
app.controller('Punchs', [ '$scope', 'punchs', function($scope, punchs) {
	$scope.number = 0;
	$scope.punchs = punchs;
	console.log(punchs);
} ]);
// ---------------------punch controller------------------------
//++++++++++++++++++++allLIst+++++++++++++++++++
app.controller('AllList', [ '$scope', 'leaves','evections', function($scope, leaves,evections) {

    console.log(leaves);
	$scope.leaves = leaves;
	$scope.evections = evections;
	
	// $scope.remove = function() { //删除未实现
	// delete $scope.punch;
	// $location.path('/me/punchs');
	// };
} ]);

// ---------------------allList------------------------
// 变量范围$scope两个页面 $rootscope全局
app.controller('ListCtrl', [ '$scope', 'recipes', function($scope, recipes) {
	$scope.recipes = recipes;
} ]);
app.controller('NewCtrl', [ '$scope', 'recipes', function($scope, recipes) {
	$scope.recipes = recipes;
} ]);

app.controller('ViewCtrl', [ '$scope', '$location', 'recipe',
		function($scope, $location, recipe) {
			$scope.recipe = recipe;

			$scope.edit = function() {
				$location.path('/edit/' + recipe.id);// edit方法，路由切换
			};
		} ]);

app.controller('EditCtrl', [ '$scope', '$location', 'recipe',
		function($scope, $location, recipe) {
			$scope.recipe = recipe;

			$scope.save = function() {
				$scope.recipe.$save(function(recipe) {// $scope下的变量继承$resource。参照restful接口的命名，具有get
					// query remove save等功能
					$location.path('/view/' + recipe.id);
				});
			};

			$scope.remove = function() {
				delete $scope.recipe;
				$location.path('/me/{userfileid}/leaves');
			};
		} ]);
