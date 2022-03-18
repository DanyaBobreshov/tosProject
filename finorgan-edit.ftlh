<#import "blocks/template.ftlh" as t>
<@t.template user>
<@t.template finorgan>
    <hr>
        <form action="finorgan-edit/${finorgan.id}" method="post">
            <div class="form-group">
                <label for="finorganTitle">Наименование</label>
                <input type="text" value="${finorgan.title}" required class="form-control"
                       id="finorganTitle" name="title">
            </div>
               <input type="hidden" name="_csrf" value="${_csrf.token}"/>
               <button type="submit" style="width: 100%" class="btn btn-dark">Редактировать</button>
    </form>
    </@t.template>
</@t.template>