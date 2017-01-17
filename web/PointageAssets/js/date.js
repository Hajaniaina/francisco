/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function date(id)
{
        date = new Date;
        annee = date.getFullYear();
        moi = date.getMonth();
        mois = new Array('1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12');
        j = date.getDate();
        jour = date.getDay();
        jours = new Array('Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi');
        h = date.getHours();
        if(h<10)
        {
                h = "0"+h;
        }
        m = date.getMinutes();
        if(m<10)
        {
                m = "0"+m;
        }
        s = date.getSeconds();
        if(s<10)
        {
                s = "0"+s;
        }
        resultat =j +'/'+mois[moi]+"/"+annee; 
        document.getElementById(id).innerHTML = resultat;
        setTimeout('date("'+id+'");','1000');
       
        return true;
}

function heure(id)
{
        date = new Date;
       
        h = date.getHours();
        if(h<10)
        {
                h = "0"+h;
        }
        m = date.getMinutes();
        if(m<10)
        {
                m = "0"+m;
        }
        s = date.getSeconds();
        if(s<10)
        {
                s = "0"+s;
        }
       
        minute= h+':'+m+':'+s;
        document.getElementById(id).innerHTML = minute;
        setTimeout('heure("'+id+'");','1000');
        return true;
}


