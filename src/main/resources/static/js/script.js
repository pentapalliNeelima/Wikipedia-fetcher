document.getElementById('search-form').addEventListener('submit', function(e) {
    e.preventDefault();
    const query = document.getElementById('query').value;
    fetch(`/fetch?query=${query}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById('result').innerHTML = `
                <h2>${data.title}</h2>
                <p>${data.extract}</p>
                <a href="${data.content_urls.desktop.page}" target="_blank">Read more on Wikipedia</a>
            `;
        })
        .catch(error => console.error('Error:', error));
});
