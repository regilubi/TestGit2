<%@ page import = "java.util.*" %>
<%@ page import = "projetwebone.objet.metier.Personne" %>

<table border="1" align="center" width="80%">
	<tr> 
		<td> 
			<div align="center"><h2> Body Page  </h2> </div>
			<p> Test d'utilisation  </p>
			
			<%-- 
			<jsp:useBean id="personne" scope="request" class="projetwebone.objet.metier.Personne"></jsp:useBean>
			<jsp:setProperty property="*" name="personne"/>
			
			
			
			<table border="1">
				<tr> 
					<th> Nom </th> <th> Prénom </th> <th> Date de naissance </th>
				</tr>
				<% for(int i=0; i < personne.getListpersonne().size(); i++){ %>
				<tr>					
					<td> <%=personne.getListpersonne().get(i).get_nom() %> </td>
					<td> <%=personne.getListpersonne().get(i).get_prenom() %> </td>
					<td> <%=personne.getListpersonne().get(i).get_datenaissance() %> </td>					
				</tr>
				<%} %>
			</table>
			--%>
			<% Personne per = new Personne(); %>
			<table border="1">
				<tr> 
					<th> Nom </th> <th> Prénom </th> <th> Date de naissance </th>
				</tr>
				<% for(int i=0; i < per.getListpersonne().size(); i++){ %>
				<tr>					
					<td> <%= per.getListpersonne().get(i).get_nom() %> </td>
					<td> <%= per.getListpersonne().get(i).get_prenom() %> </td>
					<td> <%= per.getListpersonne().get(i).get_datenaissance() %> </td>					
				</tr>
				<%} %>
			</table>
			
			
			
		</td>
	</tr>
</table>