/**
 * 
 */
$(document).ready(function() {
	$("form").on('submit', function (event) {
		$("#login-results").html("");
		event.preventDefault();
		var inputUsername = $("#inputUsername").val();
		var inputPassword = $("#inputPassword").val();
		$.ajax({
			type: "GET",
			contentType: "application/json",
			url: "/users",
			success: function(data) {
	            console.log("SUCCESS : ", data);
				for (var i = 0 ; i < data.length ; i++) {
					if (data[i].userName == inputUsername && data[i].password == inputPassword) {
						$("#login-results").html('<b style="color:green">Connexion réussie!</b>');
						var loginSuccess = true;
						return;
					}
				}
				if (!loginSuccess) {
					$("#login-results").html('<b style="color:red">Connexion échouée!</b>');
				}
			},
			error: function(e) {
				console.log("ERROR : ", e);
			}
		});
	});
});