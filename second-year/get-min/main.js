function getMin() {
    const num_elements = document.getElementsByClassName("input-num");
    const display_element = document.getElementById("display-low");
    const numbers = [];

    for (let i = 0; i < num_elements.length; ++i) {
        numbers.push(parseInt(num_elements[i].value));
        num_elements[i].value = "";
    }

    numbers.sort((a, b) => a - b);
    display_element.textContent = numbers[0];
}
