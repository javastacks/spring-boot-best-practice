function changeColor() {
    let className = document.getElementById("content").className;
    document.getElementById("content").className = className == 'red' ? 'blue' : 'red';
}