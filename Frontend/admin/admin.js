

window.addEventListener("load", ()=>{
    const open = document.getElementById('open');
    const modal_container = document.getElementById('modal_container');
    const politiciansList = document.getElementById('politiciansList');
    const electionForm = document.getElementById('electionForm');
    const close = document.getElementById('close');
    fetch("http://localhost:8080/api/politicians")
            .then(res => res.json())
            .then(data => {
                console.log(data);
                //JSON.parse(sesstionStorage.getItem("politicians")) is how to get this on diff page
                sessionStorage.setItem("politicians",JSON.stringify(data))
                createList(politiciansList,data)
            })
            .catch(error => console.log(error))

    open.addEventListener('click', () => {
        modal_container.classList.add('show');
        
    }) 

    close.addEventListener('click', () => {
        modal_container.classList.remove('show');
    })

    electionForm.addEventListener("submit", (e) => {
        e.preventDefault();
        console.log(electionForm.party.value)
        //session storeage to preserve data
        //sesstionStorage.getItem("partySelected") is how to get this on diff page
        sessionStorage.setItem("partySelected",electionForm.party.value)
        window.location.href = "/admin/selection.html"
    })
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
