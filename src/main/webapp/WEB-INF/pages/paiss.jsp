<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="paisList.title"/></title>
    <meta name="menu" content="PaisMenu"/>
</head>

<c:if test="{'$'}{not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="{'$'}{searchError}"/>
    </div>
</c:if>

<div class="col-sm-10">
    <h2><fmt:message key="paisList.heading"/></h2>

    <form method="get" action="${ctx}/paiss" id="searchForm" class="form-inline">
    <div id="search" class="text-right">
        <span class="col-sm-9">
            <input type="text" size="20" name="q" id="query" value="${param.q}"
                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
        </span>
        <button id="button.search" class="btn btn-default" type="submit">
            <i class="icon-search"></i> <fmt:message key="button.search"/>
        </button>
    </div>
    </form>

    <fmt:message key="paisList.message"/>

    <div id="actions" class="btn-group">
        <a href='<c:url value="/paisform"/>' class="btn btn-primary">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a href='<c:url value="/home"/>' class="btn btn-default"><i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>

<display:table name="paisList" class="table table-condensed table-striped table-hover" requestURI="" id="paisList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="paisform" media="html"
        paramId="id" paramProperty="id" titleKey="pais.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="pais.id"/>
    <display:column property="nombre" sortable="true" titleKey="pais.nombre"/>
    <display:column property="version" sortable="true" titleKey="pais.version"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="paisList.pais"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="paisList.paiss"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="paisList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="paisList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="paisList.title"/>.pdf</display:setProperty>
</display:table>
