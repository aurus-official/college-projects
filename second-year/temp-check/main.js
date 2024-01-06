function checkTemp() {
    const temp_element = document.getElementById("temp-input")
    const temp_value = parseInt(temp_element.value);
    const display_element = document.getElementById("display");

    temp_element.value = "";

    if (isNaN(temp_value) || temp_value.toString().trim() == "") {
        display_element.textContent = "INPUT ERROR!";
        return;
    }

    if (temp_value < 20) {
        display_element.textContent = "IT'S COLD!";
        return;
    } 

    if (temp_value > 30) {
        display_element.textContent = "IT'S HOT!";
        return;
    } 
    
    display_element.textContent = "COOL CLIMATE!";
}
