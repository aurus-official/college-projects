function compute() {
    const elements = document.getElementsByClassName("display");
    const numbers = document.getElementsByClassName("number");
    const values = [];

    let sum = 0;
    let average = 0;


    for (let num = 0; num < numbers.length; ++num) {
        if (isNaN(parseInt(numbers[num].value))) {
            elements[0].innerHTML = "?? + ?? + ?? = ERROR!";
            elements[1].innerHTML = "?? / 3 = ERROR!";
            return;
        }
        sum += parseInt(numbers[num].value); 
        values.push(numbers[num].value);
        numbers[num].value = "";
    }

    average = sum / 3;
    elements[0].innerHTML = values.join(" + ").concat(" = ").concat(sum);
    elements[1].innerHTML = sum.toString().concat(" / 3 = ").concat(average.toFixed(2));
}
