<#import "blocks/template.ftlh" as t>
<@t.template user>
<@t.template regiment>
    <hr>
        <form action="regiment-edit/${regiment.id}" method="post">
            <div class="form-group">
                <label for="regimentTitle">Наименование</label>
                <input type="text" value="${regiment.title}" required class="form-control"
                       id="regimentTitle" name="title">
            </div>
            <div class="form-group">
                            <label for="regimentName">Полное наименование и адрес</label>
                            <input type="text" value="${regiment.name}" required class="form-control"
                            id="regimentName" name="name">
            </div>
            <div class="form-group">
                                        <label for="regimentFinOrgan">Финансовая организация</label>
                                        <input type="text" value="${regiment.finOrgan.title}" required class="form-control"
                                        id="regimentFinOrgan" name="finOrgan">
                        </div>
                        <div class="form-group">
                                                    <label for="regimentDivision">ОВУ</label>
                                                    <input type="text" value="${regiment.division.title}" required class="form-control"
                                                    id="regimentDivision" name="division">
                                    </div>
               <input type="hidden" name="_csrf" value="${_csrf.token}"/>
               <button type="submit" style="width: 100%" class="btn btn-dark">Редактировать</button>
    </form>
    </@t.template>
</@t.template>