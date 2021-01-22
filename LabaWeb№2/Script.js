let arr = [
    {
        "id": 1,
        name: "Bugatti Chiron",
        "price": "3000000",
        "speed": "420"
    },
    {
        "id": 2,
       name: "Bugatti Divo",
        "price": "8000000",
        "speed": "380"
    },
    {
        "id": 3,
        name: "Bugatti La Voiture Noire",
        "price": "11000000",
        "speed": "420"
    }
];
if (localStorage.getItem("car") == null)
    localStorage.setItem("car", JSON.stringify(arr));

let maintab = JSON.parse(localStorage.getItem("car"));

function viewall() {
    tab1.innerHTML = `<tr>
        <td width="1%">
            &nbsp;
        </td>
        <td width="13%">
            Уникальный номер
        </td>
        <td width="13%">
            Название авто
        </td>
        <td width="13%">
            Цена
        </td>
        <td width="13%">
            Максимальная скорость
        </td>
        <td width="4.5%">
            &nbsp;
        </td>
    </tr>`;
    for (let i = 0; i < maintab.length; i++) {

        let str = document.createElement("tr");
        let td1 = document.createElement("td");
        td1.innerHTML = "<input type='checkbox'>";
        str.appendChild(td1);
        let td2 = document.createElement("td");
        td2.innerHTML = maintab[i].id;
        str.appendChild(td2);
        let td3 = document.createElement("td");
        td3.innerHTML = maintab[i].name;
        str.appendChild(td3);
        let td4 = document.createElement("td");
        td4.innerHTML = maintab[i].price;
        str.appendChild(td4);
        let td5 = document.createElement("td");
        td5.innerHTML = maintab[i].speed;
        str.appendChild(td5);
        let td6 = document.createElement("td");
        td6.innerHTML = "<button onclick='deletepos(" + maintab[i].id + ")'>Удалить</button>"
        str.appendChild(td6);
        tab1.appendChild(str);
    }
}

function deletepos(id) {
    for (let i = 0; i < maintab.length; i++) {
        if (id == maintab[i].id) {
            maintab.splice(i, 1);
        }

    }
    viewall();
    localStorage.setItem("car", JSON.stringify(maintab));
}

function closeForm() {
    adder.style.display = "none";
}


function add() {
    let obj = {
        "id": maintab[maintab.length - 1].id + 1,
        name: name1.value,
        "price": price1.value,
        "speed": speed1.value,
    };
    maintab.push(obj);
    localStorage.setItem("car", JSON.stringify(maintab));
}