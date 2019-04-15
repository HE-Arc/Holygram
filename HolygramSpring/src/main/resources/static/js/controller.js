function fetchAjax(url, csrftok, payload)
{
    // Build headers
    var headers = new Headers();
    headers.append('X-CSRF-TOKEN', csrftok);
    headers.append('Content-Type', 'application/json');

    // Build request body
    var data = new FormData();
    data.append("json", JSON.stringify(payload));

    // Build post params
    var init = {
        method: "POST",
        headers: headers,
        mode: 'cors',
        cache: 'default',
        body: data,
    };

    // send command
    fetch(url, init)
    .then(function (response) {
        console.log(response)
        return response;
    }).catch(function (error) {
        console.log(error)
        return error;
    });
}