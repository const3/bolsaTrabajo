<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="paisDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='paisDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="paisList.pais"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-2">
    <h2><fmt:message key="paisDetail.heading"/></h2>
    <fmt:message key="paisDetail.message"/>
</div>

<div class="col-sm-7">
<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
<form:form commandName="pais" method="post" action="paisform" cssClass="well"
           id="paisForm" onsubmit="return validatePais(this)">
<form:hidden path="id"/>
    <spring:bind path="pais.nombre">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="pais.nombre" styleClass="control-label"/>
        <form:input cssClass="form-control" path="nombre" id="nombre"  maxlength="50"/>
        <form:errors path="nombre" cssClass="help-block"/>
    </div>
    <spring:bind path="pais.version">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="pais.version" styleClass="control-label"/>
        <form:input cssClass="form-control" path="version" id="version"  maxlength="255"/>
        <form:errors path="version" cssClass="help-block"/>
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty pais.id}">
            <button type="submit" class="btn btn-warning" name="delete" onclick="bCancel=true;return confirmMessage(msgDelConfirm)">
                <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
            </button>
        </c:if>

        <button type="submit" class="btn btn-default" name="cancel" onclick="bCancel=true">
            <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
        </button>
    </div>
</form:form>
</div>

<v:javascript formName="pais" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['paisForm']).focus();
    });
</script>
