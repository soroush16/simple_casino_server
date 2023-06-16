let stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#results").html("");
}

function connect() {
    let socket = new SockJS('/casino-server');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/user/queue/reply', function (result) {
            showResult(JSON.parse(result.body));
        });
        stompClient.subscribe('/user/queue/errors', function (errorMessage) {
            showErrorPopup(JSON.parse(errorMessage.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    stompClient.send("/app/process-message", {}, JSON.stringify({'bet': $("#bet").val(), 'number': $("#number").val()}));
}

function showError(selector, errorMessage) {
    $(selector).text(errorMessage);
}

function showErrorPopup(errorMessage) {
    $("#errorMessage").text(errorMessage);
    $("#errorMessageModal").modal("show");
}
function displayResultFields(result) {
    $("#results").html("");
    for (let field in result) {
        if (result.hasOwnProperty(field)) {
            let fieldValue = result[field];
            let fieldHTML = "<tr><td><strong>" + field + ":</strong></td><td>" + fieldValue + "</td></tr>";
            $("#results").append(fieldHTML);
        }
    }
}


function showResult(message) {
    //$("#results").append("<tr><td>" + message+ "</td></tr>");
    displayResultFields(message)
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendMessage(); });
});