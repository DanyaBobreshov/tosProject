<#import "blocks/template.ftlh" as t>
<@t.template user>
<@t.template division>
    <hr>
        <form action="division-edit/${division.id}" method="post">
            <div class="form-group">
                <label for="divisionTitle">Наименование</label>
                <input type="text" value="${division.title}" required class="form-control"
                       id="divisionTitle" name="title">
            </div>
               <input type="hidden" name="_csrf" value="${_csrf.token}"/>
               <button type="submit" style="width: 100%" class="btn btn-dark">Редактировать</button>
    </form>
    </@t.template>
</@t.template>