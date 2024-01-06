function chooseOperation(operation) {
    const output_element = document.getElementById("output");
    const first_num = document.getElementById("first").value;
    const second_num = document.getElementById("second").value;

    if (isNaN(parseInt(first_num)) || isNaN(parseInt(second_num))) {
        output_element.innerHTML = "?? ? ?? = ERROR!";
        document.querySelector("#first").value = ""
        document.querySelector("#second").value = ""
        return;
    }

    switch (operation) {
        case "add":
            add.call(this, first_num, second_num, output_element);
            break;
    
        case "subtract":
            subtract.call(this, first_num, second_num, output_element);
            break;
    
        case "multiply":
            multiply.call(this, first_num, second_num, output_element);
            break;
    
        case "divide":
            divide.call(this, first_num, second_num, output_element);
            break;
    }

    document.querySelector("#first").value = ""
    document.querySelector("#second").value = ""
}

function add(first_num, second_num, output_element) {
    output_element.innerHTML = first_num.concat(" + ").concat(second_num).concat(" = ").concat(parseInt(first_num) + parseInt(second_num));
}

function subtract(first_num, second_num, output_element) {
    output_element.innerHTML = first_num.concat(" - ").concat(second_num).concat(" = ").concat(parseInt(first_num) - parseInt(second_num));

}

function multiply(first_num, second_num, output_element) {

    output_element.innerHTML = first_num.concat(" * ").concat(second_num).concat(" = ").concat(parseInt(first_num) * parseInt(second_num));

}

function divide(first_num, second_num, output_element) {
    if (second_num == 0) {
        output_element.innerHTML = "Zero Division Error!"
        return;
    }

    output_element.innerHTML = first_num.concat(" / ").concat(second_num).concat(" = ").concat((parseInt(first_num) / parseInt(second_num)).toFixed(2));
}
