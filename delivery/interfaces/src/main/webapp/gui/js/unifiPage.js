define(['require','utils','profile','publicKeys', 'certificates','server','index'],
/**
 * @lends UnifiPage
 */ 
function(require,Utils,Profile,PublicKeys,Certificates,Server){
	
	console.log("unifiPage.js is loaded");
	 /** 
	 * The FITeagle main page class contains functions required for initialization of the 
	 * main page forms and elements located on the page.
     * @class
     * @constructor
     * @return Unifi Object
     */
	Unifi = {};
	
	/**
	* Collapses sections identified by "#yourSliceList" and "#availableSlicesList" selectors
	* @param {Boolean} boolean value that triggers collapse function. 
	* True value collapses the container, false otherwise opens it.
	* @private
	* @memberOf Unifi#
	*/
	collapseAsideSections = function(bool){
		var sliceList = $("#yourSliceList");
		var availableSlices  = $('#availableSlicesList');
		if(bool){
			sliceList.removeClass('in');
			availableSlices.removeClass('in');
		}else{
			if(!sliceList.hasClass('in')){
					sliceList.addClass('in');
			}
			if(!availableSlices.hasClass('in')){
					availableSlices.addClass('in');
			}	
		}
	};
	
	/**
	* Creates and appends to the body confirmation modal to be shown before signing out. 
	* The user is signed out only after confirming his decision.
    * @private
    * @memberOf Unifi#
	* @return {Object} sign out modal object
	*/
	createSignOutModal = function(){
		var modalBody = $('<div>').addClass('centered').append('<h5>'+Messages.signOutConfirm+'</h5>')
		var signOutModal = Utils.createConfirmModal('signOutModal','signOutOkBtn','YES','NO',modalBody);
		$('body').append(signOutModal);
		return signOutModal;
	}
	
	
	/**
	* Disables all links within the aside section in order to prevent quitting from the main page by
	* clicking on an undefined link. The function has to be removed before implementing a functionality for the links
	* inside the aside section.
	* @private
    * @memberOf Unifi#
	*/
	disableAsideLinks = function(){
		$('#aside').find('a').each(function(){
			$(this).on('click',function(e){
				e.preventDefault();
				return false;
			})
		});
	};
		
	/**
	* Initializes change of the icon sign for all of the headers with the class with  the ".collapseHeader" selector after clicking on it.
	* @private
	* @memberOf Unifi#
	*/
	initCollapseHeaders = function(){
		$('.collapseHeader').on('click',function(){
			var icon = $(this).find('.collapseSign');
			window.setTimeout(function(){
				initCollapseSignFor(icon);
			},100);
		});
	};
			
	/**
	* Initializes the icon sign replacement within the given container according to the current section state. 
	* Icon chevron right from the font awesome icons is shown if the section is collapsed and icon chevron right is section is opened.
 	* @param {Object} icon_object is a container object to change the icon sign after the section is opened or collapsed.
	* @private
	* @memberOf Unifi#
	*/
	initCollapseSignFor = function(icon_object){
		var selector = icon_object.closest('div').attr('data-target');
		var isOpen  = $(selector).hasClass('in');
			//console.log("selector" + selector + " is open " + isOpen);
			if(isOpen){
				icon_object.attr('class','');
				icon_object.addClass('collapseSign icon-chevron-down');
			}else{
				icon_object.attr('class','');
				icon_object.addClass('collapseSign icon-chevron-right');
		}
	};
	
	/**
	* Initializes change of the icon sign for all of the elements with the class with  the ".collapseSign" selector.
	* @private
	* @memberOf Unifi#
	*/
	initCollapseSigns = function(){
		var icons = $('.collapseSign');
		icons.each(function(){
			var t = $(this);
			initCollapseSignFor(t);
		});		
	};
		
	/**
	* Defines the behaviour for the large size devises. Opens Aside sections for better representation on the wide window screen.
	* Hides small screen navigation toolbar.
    * @private
	* @memberOf Unifi#
	*/
	initForLargeScreens = function(){
		collapseAsideSections(false);	
		Utils.hideElement('#toolbar .btn-navbar');
	};
	
	/**
	* Defines the behaviour for the small size devises. Collapses Aside sections for better representation on the narrow window screen.
	* Unhides small screen navigation toolbar.
    * @private
	* @memberOf Unifi#
	*/
	initForSmallScreens = function(){
		collapseAsideSections(true);	
		Utils.unhideElement('#toolbar .btn-navbar');		
	};
	
	/**
	* Defines the behaviour for clicking on "back" or "next" browser buttons aka browser history.
	* The function opens the appropriate form views.
	* @private
	* @memberOf Unifi#
	*/
	initHashtagChange = function(){
		$(window).unbind();
		$(window).on('popstate hashchange',function(){
			var state = window.location.hash;
			openTab(state);
		});
	};

	/**
	* Triggers functions for main Page initialization such as: screen adjustments by resizing, initialization of user panel, profile form,
	* public keys form, manage certificates form, and showing of the last opened tab.
    * @private
	* @memberOf Unifi#
	*/
	initUnifiPage = function(){
		$('#fiteagle').addClass('mainWindow'); // class in order to distinguish between main and login pages
		performScreenAdjustments();	
//		initUserInfoPanel();		
//		Profile.initForm();
//		PublicKeys.initForm();
//		Certificates.initForm();
//		checkForStoredHashTags();
//		disableAsideLinks();
		
	};
	
	/**
	* Initializes scrolling for small screen devices to the container specified by a selector. 
	* The scrolling lasts one second and has an offset of navigation menu height.
	* @param selector - container selector to scroll to
 	* @private
	* @memberOf Unifi#
	*/
	initScrollToForm = function(selector){
		var scrollTo = $(selector);
		if(Utils.isSmallScreen()){
			setTimeout(function(){
				$('html, body').animate({
					 scrollTop: scrollTo.offset().top-15-$('#navigation').height()
				}, 1000);
			},100)
		}	
	};
	
	/**
      * Defines the behaviour after clicking on the singOut button: Cookie invalidation on the server and singing out of the current user. 
	  * @private
	  * @memberOf Unifi#
     */ 
	initSignOutBtn = function(){
		$("#unifiSignOut").on('click',function(e){
			e.preventDefault();
			//console.log("signOut clicked");	
			var modal = createSignOutModal();
			modal.modal('show');
			$('#signOutOkBtn').on('click',function(){
				var isCookieDeleted = Server.invalidateCookie();
//				alert("unifi sign out will be called!");
				modal.modal('hide');
				if(isCookieDeleted) Unifi.signOut();
			});
		});
	};
	
	/**
      * Initiates user info panel located in the main page header section. Defines the behaviour for clicking on the panel items: 
	  * opening the corresponding window. Sets current user first and last name in it.
	  * Scrolls to the appropriate fields to the top after they are selected from the menu.
	  * Triggers sign out button initialization.
	  * @private
	  * @memberOf Unifi#
      */ 
	initUserInfoPanel = function(){		
		var navLinks = $("#userInfoDropdown a");
		navLinks.off();
		navLinks.not('#unifiSignOut').on('click',function(e){
			e.preventDefault();
			var t = $(this);
			var linkID  = t.attr("id");
			var linkHref = t.attr('href');
			var lis = $("#userInfoDropdown li");
			lis.removeClass("active");	
			initScrollToForm(linkHref+' h4.collapseHeader');
			var hash = linkHref.toLowerCase();
			history.pushState(linkHref, "page "+linkHref, "/"+hash);
			$('[href$='+linkHref+']').tab('show');			
		});
		Utils.updateUserInfoPanel();
		initSignOutBtn();
		initHashtagChange();
	};
	
	/**
	* Loads HTML for the FITeagle main page dynamically and triggers the page initialization after the loading is successfully completed.
	* @public
	* @name Unifi#load
	* @function
	**/
	Unifi.loadUserPage = function(){
		console.log("loading main Page for user");
		
		var url = "unifi.html";
		$("#navigation").load(url + " #toolbar",
			function(){
				$("#main").load(url + " #mainArea",
					function(){								
						initUnifiPage();
						$("#aside").empty().load(url + " #userCourses");
						$("#desktop").empty();
					});
			}
		);
		
	};
	
	Unifi.loadUserCourse = function(){
		var url = "unifi.html";
		$("#desktop").empty().load(url + " #userCourse");
	};
	
	Unifi.loadUserAddCourse = function(){
		var url = "unifi.html";
		$("#desktop").empty().load(url + " #addCourse");
	};
	
	
	Unifi.loadAdminPage = function(){
		console.log("loading main Page for admin");
		
		var url = "unifi.html";
		$("#navigation").load(url + " #toolbar",
			function(){
				$("#main").load(url + " #mainArea",
					function(){								
						initUnifiPage(); 
						$("#desktop").empty().load(url + " #testbedDetails");
					});
			}
		);
		
	};
	
	Unifi.loadTestbedOwnerPage = function(){
		console.log("loading main Page for tbOwner");
		
		var url = "unifi.html";
		$("#navigation").load(url + " #toolbar",
			function(){
				$("#main").load(url + " #mainArea",
					function(){								
						initUnifiPage(); 
						$("#desktop").empty();
						$("#aside").empty().load(url + " #courses");
					});
			}
		);
	};
	
	Unifi.loadCourse = function(){
		var url = "unifi.html";
		$("#desktop").empty().load(url + " #course");
	};
	
	/**
	* Opens the appropriate tab from the user info dropdown menu on the Unifi page according to the
	* hash tag entered in the browser's url field. The function searches within a "user info dropdown" menu
	* for a link with the reference showing to the specified container.
	* If no tab is found for a hash tag then "manage profile" tab is opened per default.
	* @see Twitter Bootstrap tab documentation for more information.
	* @param {String} hash - tag to opening a form for.
	* @example openTab('#keys') tries to open a tab identified by a "#keys" selector
	* @private
	* @memberOf Unifi#
	*/
	openTab = function(hash){
		if(hash != null){
			var lis = $("#userInfoDropdown li");
			lis.removeClass("active");
			var a = $('#userInfoDropdown [href$='+hash+']');
			(a.length)?
				a.tab('show') // if found show the tab
					:
				$('[href$=#manage]').tab('show'); // if not found show manage profile tab
		}
	};
	
	/**
	* Triggers functions for adjusting the site view for better representing depending on the current screen size such as:
	* collapsing of the opened sections for small screen devices and opening for a large ones and other related tasks.
    * @private
	* @memberOf Unifi#
	*/
	performScreenAdjustments = function(){
		Utils.unhideBody();
		initCollapseHeaders();
		if(Utils.isSmallScreen()){
			initForSmallScreens();
		}else{
			initForLargeScreens();
		}
		initCollapseSigns();
	};

	/**
	* Signs out the current user. Resets its data in the session storage and loads the login page.  
	* @public
	* @name Unifi#signOut
	* @function
	**/
	Unifi.signOut = function(){
		Login.load();
	};
	
	return Unifi;
	
});



