function setupNewPortletInfo(ctx) {
	
	// Configure Origin City
	$("#originEstateSelectId").CascadingDropDown("#originCountrySelectId", ctx + '/ajaxrequest/estateselect', {
        promptText: 'Seleccione uno...',
        loadingText: 'Cargando...',
        errorText: 'Error cargando datos...',
        postData: function () { 
            return { countrySelectId: $('#originCountrySelectId').val() }; 
        },
        onLoading: function () {
            $(this).css("background-color", "#fff");
        },
        onLoaded: function () {
            $(this).animate({ backgroundColor: '#ffffff' }, 300);
        }
    });
    $("#originCitySelectId").CascadingDropDown("#originEstateSelectId", ctx + '/ajaxrequest/cityselect', {
        promptText: 'Seleccione uno...',
        loadingText: 'Cargando...',
        errorText: 'Error cargando datos...',
        postData: function () { 
            return { estateSelectId: $('#originEstateSelectId').val() }; 
        },
        onLoading: function () {
            $(this).css("background-color", "#fff");
        },
        onLoaded: function () {
            $(this).animate({ backgroundColor: '#ffffff' }, 300);
        }
    });
}