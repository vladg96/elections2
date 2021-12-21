window.addEventListener("load", ()=>{
    const politiciansList = document.getElementById('politiciansList');
    const politicians = JSON.parse(sessionStorage.getItem("politicians"))
    const selectedParty = sessionStorage.getItem("partySelected")
    document.getElementById('partyTitle').innerText = selectedParty

    console.log(politicians)
    console.log(selectedParty)
    const filteredPoliticians = politicians.filter(politician => politician.party === selectedParty)
    console.log(filteredPoliticians)
    createList(politiciansList,filteredPoliticians)
})

const createList = (parrentNode,list) => {
    let HTML = ``;
    list.forEach((politician, i) => {
        HTML += `
        <li class="listJS" >
            ${politician.name} 
            <span>
                <button class="edit" >Edit Member</button>
                <button class="delete" >Delete Member</button>
            </span>
        </li>
        `
    });
    parrentNode.innerHTML = HTML;
}