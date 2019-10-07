var slider = document.getElementById("myRange");
var output = document.getElementById("gasEffectivityValue");

output.innerHTML = slider.value;

slider.oninput = function(){
	output.innerHTML = this.value;
}

slider.addEventListener("mousemove", function(){
	var x = slider.value;
})