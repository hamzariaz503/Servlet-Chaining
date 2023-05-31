
"use strict";  

const username=document.getElementById('uname');
const Password=document.getElementById('psw');
const Address=document.getElementById('add');
const Telephone=document.getElementById('tel');
const confirmPassword=document.getElementById('repeat');


const unameErr=document.getElementById('unameErr');
const pswErr=document.getElementById('pswErr');
const addErr=document.getElementById('addErr');
const telErr=document.getElementById('telErr');
const confirmErr=document.getElementById('repeatErr');


const SignUpBtn=document.getElementById('SignUpBtn');


SignUpBtn.addEventListener('click',function(e)
{
    e.preventDefault();
      
    PasswordValidation();
   UsernameValidation();
 AddressValidation();
   
     TelephoneValidation();
    confirmValidation();
    
    
    
})

function PasswordValidation()
{
    if(Password.value==''||Password.value.length<8)
    {
       
       pswErr.innerHTML= `* Password must be  at least 8  characters *` ;
    }

    else if(Password.value.length>=8)
    {
       pswErr.innerHTML=``;
    }

}

function UsernameValidation()
{
  
    if(username.value==''||username.value.length<6||username.value==null)
    {
       
      unameErr.innerHTML= `* Username must be  at least 6  characters *` ;
    }

    else if(!isNaN(username.value))
    {
      alert(" Username can't be only Numbers");
    }
    

    else if(username.value.length>=8)
    {
       unameErr.innerHTML=``;
    }
 
   

  

}

function AddressValidation()
{
    if(Address.value==''||username.value==null)
    {
      addErr.innerHTML= `* Address field must be filled *` ;
    }

    else if(!isNaN(username.value))
    {
      alert("Address can't be only Numbers");
    }

  else  if(Address.value.length>0)
    {
        addErr.innerHTML=``;
    }

}

function TelephoneValidation()
{

    if(Telephone.value==''||Telephone.value==null||Telephone.value.length!=11)
    {
       
      telErr.innerHTML= `* Phone Number must be exactly 11 digit long*` ;
      return;
    }

     else if(Telephone.value.length==11)
    {
        telErr.innerHTML=``;
    }

}

function confirmValidation()
{
    if(confirmPassword.value==''|| (confirmPassword.value!==Password.value))
    {
       
      confirmErr.innerHTML= `* Password must be match *` ;
    }

    else if(confirmPassword.value===Password.value)
    {
        confirmErr.innerHTML=``;
    }

}