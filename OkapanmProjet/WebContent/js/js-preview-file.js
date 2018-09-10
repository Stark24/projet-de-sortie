function displayImage()
{
    if(this.files && this.files[0])
    {
        var obj = new FileReader();
        obj.onload = function(data)
        {
            var imges = document.getElementById("image");
            imges.src = data.target.result;
            imges.style.display = "block";
        }
        obj.readAsDataURL(this.files[0]);
    }
}