<#import "blocks/template.ftlh" as t>
<@t.template user>
<@t.template transfer>
    <hr>
        <form action="transfer-edit/${transfer.id}" method="post">
            <div class="form-group">
                <label for="transferTitle">Наименование</label>
                <input type="text" value="${transfer.title}" required class="form-control"
                       id="transferTitle" name="title">
            </div>
               <input type="hidden" name="_csrf" value="${_csrf.token}"/>
               <button type="submit" style="width: 100%" class="btn btn-dark">Редактировать</button>
    </form>
    </@t.template>
</@t.template>