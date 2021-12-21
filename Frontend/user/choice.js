window.addEventListener("load", ()=>{
    fetch("http://localhost:8080/api/politicians")
            .then(res => res.json())
            .then(data => {
                console.log(data);
                const politiciansList = document.getElementById('politiciansList');
                createList(politiciansList,data)
            })
            .catch(error => console.log(error))

})

const createList = (parrentNode,list) => {
    let HTML = ``;
    list.forEach((politician, i) => {
        HTML += `
        <li>${politician.name}</li>
        `
    });
    parrentNode.innerHTML = HTML;
}