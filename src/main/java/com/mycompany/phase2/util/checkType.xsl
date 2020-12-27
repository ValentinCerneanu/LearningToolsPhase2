<xsl:stylesheet version="1.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format">

<xsl:template match="/">
	<table border="1">
		<tr bgcolor="#9acd32">
			<th>Name</th>
			<th>Url</th>
			<th>Category</th>
			<th>Type</th>
			<th>Action</th>
		</tr>
		<xsl:for-each select="tools/tool">
			<xsl:if test="type = 'learning'">
				<tr style="background-color:#09e335">
					<td><xsl:value-of select="name"/></td>
					<td><xsl:value-of select="url"/></td>
					<td><xsl:value-of select="category"/></td>
					<td><xsl:value-of select="type"/></td>
					<td>
						<a href="ShowDetailsView?id={@id}">Show details</a>
					</td>
				</tr>
			</xsl:if>
			<xsl:if test="type = 'teaching'">
				<tr style="background-color:#f0f016">
					<td><xsl:value-of select="name"/></td>
					<td><xsl:value-of select="url"/></td>
					<td><xsl:value-of select="category"/></td>
					<td><xsl:value-of select="type"/></td>  
					<td>
						<a href="ShowDetailsView?id={@id}">Show details</a>
					</td>
				</tr>
			</xsl:if>
		</xsl:for-each>
	</table>
</xsl:template>
</xsl:stylesheet>



