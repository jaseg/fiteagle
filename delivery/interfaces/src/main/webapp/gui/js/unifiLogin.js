define([ 'require', 'validation', 'registration', 'utils', 'messages',
		'history', 'ajaxify', 'prettyCheckable' ],

function(require, Validation, Registration, Utils, Messages) {

	console.log("unifiLogin.js is loaded");

	/**
	 * The Login class contains functions required for initialization of the
	 * forms and elements located on the login page.
	 * 
	 * @class
	 * @constructor
	 * @return Login Object including the public functions to be called inside
	 *         other modules.
	 */
	UnifiLogin = {};

	UnifiLogin.initUnifiPage = function() {
//		alert("unifi login INIT UNIFI PAGE is calledis called!");
		// $('#fiteagle').removeClass('mainWindow');
		// toggleNavigationBtn();
		// redirectToUrl();
		// Utils.unhideBody();
		// initOnWindowResizeEvent();
		// initRegisterLink();
		// initLoginForm();
		// initSignInBtn();
		// Registration.initRegistrationForm();
		// initOnWindowResizeEvent();
		// initHistory();
		// onFITeagleLogoClicked();
		// Status.init();
	};

	/**
	 * Initiates on window resize event that toggles navigation button
	 * visibility, re-initiates tooltips for the login and registration form
	 * depending on a current screen size.
	 * 
	 * @private
	 * @memberOf Login#
	 * @see Registration.initRegistrationFormHints for more information about
	 *      the tooltip initialization for the registration form
	 */
	initOnWindowResizeEvent = function() {
		$(window).resize(function() {
			toggleNavigationBtn();
			initLoginFormHints();
			Registration.initRegistrationFormHints();
		});
	};

	// /**
	// * Initiates on enter click event for "register" link identified by
	// #registrationLink on the Home page.
	// * The link opens the registration tab on the login page.
	// * @private
	// * @memberOf Login#
	// */
	// initRegisterLink = function(){
	// $("#registrationLink").on('click',function(e){
	// e.preventDefault();
	// $("#registrationTab").click();
	// });
	// };

	/**
	 * Initiates on click event for "signIn" button on the Home page identified
	 * by #signIn. The Function Login.loginUser() is called after clicking on
	 * this button.
	 * 
	 * @private
	 * @memberOf Login#
	 * @see Login.loginUser
	 */
	initStudentSignInBtn = function() {
		$("#studentSignIn").on('click', function() {
//			alert("student sign in is clicked!");
			// console.log("SignIn button clicked !");
			Utils.clearErrorMessagesFrom("#loginErrors");
			Unifi.load();
			// Login.loginUser();
		});
	};

	initAdminSignInBtn = function() {
		$("#adminSignIn").on('click', function() {
//			alert("admin sign in is clicked!");
			// console.log("SignIn button clicked !");
			Utils.clearErrorMessagesFrom("#loginErrors");
			Unifi.load();
		});
	};

	/**
	 * Checks if there is a user that has been already logged into the system.
	 * 
	 * @return {Boolean} true is returned if there is a logged user, false
	 *         otherwise.
	 * @public
	 * @name Login#isUserLoggedIn
	 * @function
	 */
	Login.isUserLoggedIn = function() {
		var user = Utils.getCurrentUser();
		// console.log('Current User: ' + Utils.userToString());
		if (!user) {
			return false;
		}
		return true;
	};

	/**
	 * Loads the HTML for the loading page into the DOM and triggers the loading
	 * page initialization function.
	 * 
	 * @public
	 * @name Login#load
	 * @function
	 * @see Login#initLoginPage function
	 */
	UnifiLogin.load = function() {
		// console.log("loading Login Page...");
		var url = "unifi.html";
		$("#navigation").load(url + " #toolbar", function() {
			$("#main").load(url + " #mainArea", function() {
				UnifiLogin.initLoginPage();
			})
		});
	};


	/**
	 * The function analyses the hash tag from the url and opens the appropriate
	 * tab if the tag is known otherwise it stores the value in order to make
	 * possible to open a tab for this tag if other page is loaded e.g. fiteagle
	 * main page.
	 * 
	 * @private
	 * @memberOf Login#
	 */
	redirectToUrl = function() {
		var href = window.location.hash;
		if (href == null || href == '') {
			$('#navigation [href$=#home]').tab('show');
		} else {
			var tab = $('#navigation [href$=' + href + ']');
			(tab.length) ? tab.tab('show') :
			// if this hashtag is not found on this page
			Utils.storeHashTag(href); // store the hashtag to try open it on
										// main page
		}
	};

	/**
	 * Toggles navigation button depending on the screen size width. It is shown
	 * on a small screen window and hidden on a large one.
	 * 
	 * @private
	 * @memberOf Login#
	 * @function
	 */
	toggleNavigationBtn = function() {
		if (Utils.isSmallScreen()) {
			$('.btn-navbar').removeClass('hidden');
		} else {
			$('.btn-navbar').addClass('hidden');
		}
	};

	UnifiLogin.initUnifiLogin = function() {
//		alert("unifi login init unifi page is calledis called!");
		initStudentSignInBtn();
		initAdminSignInBtn();
	};

	return UnifiLogin;
});