// JavaScript Document
/*
 SCRIPT EDITE SUR L'EDITEUR JAVASCRIPT
 http://www.editeurjavascript.com
 */
 
 if(document.getElementById)
 	{
 	/* LE HAUT DU CADRE */
 	access_list_haut = "<TABLE WIDTH=270 CELLPADDING=0 CELLSPACING=0 BORDER=0 BGCOLOR=#538EAB><TR><TD><TABLE WIDTH=100% CELLPADDING=3 CELLSPACING=1 BORDER=0><TR><TD BGCOLOR=#538EAB width=250><FONT FACE=Verdana SIZE=1 COLOR=#FFFFFF><B>Accès rapides : (Alt + W + Entrer)</B></FONT></TD><TD BGCOLOR=#538EAB><FONT FACE=Verdana SIZE=2><B><A HREF=# onClick=\"accessAff(0);return(false)\" style=\"COLOR:#FFFFFF;text-decoration:none;\" title=\"Fermer la fenêtre d'accès rapide\">X</A></B></FONT></TD></TR><TR><TD BGCOLOR=#88B1C5 colspan=2><FONT FACE=Verdana SIZE=1 COLOR=#000000>";
 	/* LE BAS DU CADRE */
 	access_list_bas = "<BR><BR><A HREF=# onClick='accessAdd(1);return(false)' class=\"lien\">&lt; Mettre la page actuelle en accès rapide &gt;</A><BR></FONT></TD></TR></TABLE></TD></TR></TABLE>";
 	access_list_1 = new Array;
 	access_list_2 = new Array;
 	access_book = "";
 	if(navigator.appName.substring(0,3) == "Net")
 	document.captureEvents(Event.MOUSEMOVE);
 	document.onmousemove = acces_get_mouse;
 	}
 
 function accessRead()
 	{
 	access_list = "<B>Vos pages en accès rapide :</B><BR>";
 	access_cook = document.cookie;
 	access_variable = "access_book=";
 	access_place = access_cook.indexOf(access_variable,0);
 	if (access_place <= -1)
 		access_list = "Vous n'avez pas de page en accès rapide";
 	else
 		{
 		access_end = access_cook.indexOf(";",access_place)
 		if (access_end <= -1)
 			access_book = unescape(access_cook.substring(access_place+access_variable.length,access_cook.length));
 		else
 			access_book = unescape(access_cook.substring(access_place+access_variable.length,access_end));
 		if(access_book.indexOf("|",0)>=0)
 			{
 			access_list_1 = access_book.split("|");
 			for(a=0;a<access_list_1.length;a++)
 				{
 				if(access_list_1[a].indexOf("%",0)>=0)
 					{
 					access_list_2 = access_list_1[a].split("%");
 					if(access_list_2[1].length > 40)
 						access_list_2[1] = access_list_2[1].substring(0,35)+"...";
 					access_list += '. <A HREF="'+access_list_2[0]+'" class=\"lien\">'+access_list_2[1]+'</A> [<A HREF=# onClick="accessDel(\''+access_list_2[0]+'\');return(false)" class=\"lien\">del</A>]<BR>';
 					}
 				}
 			}
 		else
 			access_list = "Vous n'avez pas de page en accès rapide";
 		}
 	return(access_list);
 	}
 
 
 function acces_get_mouse(e)
 	{
 	access_X = (navigator.appName.substring(0,3) == "Net") ? e.pageX : event.x+document.body.scrollLeft;
 	access_Y = (navigator.appName.substring(0,3) == "Net") ? e.pageY : event.y+document.body.scrollTop;
 	}
 	
 function accessAff(access_mode)
 	{
 	if(access_mode == 0 && document.getElementById)
 		{
 		document.getElementById("access_box").style.visibility = 'hidden';
 		}
 	if(access_mode == 1 && document.getElementById)
 		{
 		document.getElementById("access_box").innerHTML = access_list_haut+accessRead()+access_list_bas;
 		document.getElementById("access_box").style.visibility = 'visible';
 		document.getElementById("access_box").style.left = access_X;
 		document.getElementById("access_box").style.top = access_Y;
 		}
 	if(!document.getElementById)
 		alert('Cette fonction n\'est pas compatible avec votre navigateur.\nMettez à jour votre matériel :)\nIE 5+ / NN6 +\n')
 	}
 	
 function accessAdd(access_mode)
 	{
 	if(access_mode==1)
 		{
 		access_url = document.location.href;
 		access_titre = document.title;
 		document.getElementById("access_box").innerHTML = access_list_haut+"<B>Vous désirez ajouter la page :</B><BR>"+access_url.substring(0,40)+"...<BR>dans vos accès rapides.<BR><BR><FORM NAME=access_form>Entrez le nom que vous désirez donner à cette page :<BR><INPUT TYPE=text NAME=access_name VALUE=\""+access_titre+"\" STYLE=width:200>&nbsp;<INPUT TYPE=button VALUE=OK onClick='accessAdd(2)' class=\"bouton\"></FORM>"+access_list_bas;
 		} 
 	if(access_mode==2)
 		{
 		if(document.access_form.access_name.value=="")
 			access_titre = document.title;
 		else
 			access_titre = document.access_form.access_name.value;
 		accessCookie('access_book',access_book+document.location.href+"%"+access_titre+"|");
 		document.getElementById("access_box").innerHTML = access_list_haut+accessRead()+access_list_bas;
 		} 
 	}
 	
 function accessCookie(access_nom,access_valeur)
 	{
 	access_dateExp = new Date(2020,01,01);
 	access_dateExp = access_dateExp.toGMTString();
 	document.cookie = access_nom + '=' + escape(access_valeur) + '; expires=' + access_dateExp + ';path=/';
 	}
 	
 function accessDel(access_to_del)
 	{
 	access_new_cookie = "";
 	access_cook = document.cookie;
 	access_variable = "access_book=";
 	access_place = access_cook.indexOf(access_variable,0);
 	if (access_place >= 0)
 		{
 		access_end = access_cook.indexOf(";",access_place)
 		if (access_end <= -1)
 			access_book = unescape(access_cook.substring(access_place+access_variable.length,access_cook.length));
 		else
 			access_book = unescape(access_cook.substring(access_place+access_variable.length,access_end));
 		if(access_book.indexOf("|",0)>=0)
 			{
 			access_list_1 = access_book.split("|");
 			for(a=0;a<access_list_1.length;a++)
 				{
 				if(access_list_1[a].indexOf("%",0)>=0)
 					{
 					access_list_2 = access_list_1[a].split("%");
 					if(access_list_2[0]!=access_to_del)
 						{
 						access_new_cookie += access_list_1[a]+"|";
 						}
 					}
 				}
 			accessCookie("access_book",access_new_cookie);
 			document.getElementById("access_box").innerHTML = access_list_haut+accessRead()+access_list_bas;
 			}
 		}
 	}
 
 if(document.getElementById)
 	document.write('<DIV ID=access_box STYLE="top:0;left:0;position:absolute;z-index:9;visibility:hidden"></DIV>')
