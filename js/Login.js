
window.onload=function(){

    const unameLabel=document.getElementById('unameErr');
const PassLabel=document.getElementById('passwordErr');
const LoginBtn=document.getElementById('loginBtn');

const username=document.getElementById('uname');
const password=document.getElementById('psw');



LoginBtn.addEventListener('click',function(e)
{
    e.preventDefault();
 
 
     if(username.value=='' && password.value=='')
     {
        unameLabel.innerHTML= `*Username must be at least 6 characters*` ;
        PassLabel.innerHTML= `* Password must be  at least 8  characters *` ;
        return;
     }

     if(!isNaN(username.value))
     {
       alert(" Username can't be only Numbers");

     } 

     else if(username.value=='' && password.value!='')
     {
        unameLabel.innerHTML= `* Username must be  at least 6 characters *` ;
        return;
     }
     

     else if (username.value!='' && password.value=='')
     {
      
        PassLabel.innerHTML= `* Password must be at least 8 characters *` ;
     }

     
     if(username.value.length>=6 && password.value.length>=8)
     {
        unameLabel.innerHTML= `` ;
        PassLabel.innerHTML= `` ;
     }

     else if(username.value.length>=6 && password.value.length<8)
     {
        unameLabel.innerHTML= `` ;
 
     }

     else if(username.value.length<6&& password.value.length>=8)
     {
        PassLabel.innerHTML= `` ;
 
     }


})

  }


