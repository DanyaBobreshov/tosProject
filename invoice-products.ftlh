<#import "blocks/template.ftlh" as t>
<@t.template user>
<@t.template invoice>
    <hr>
       <h1 style="text-align: center">НАРЯДЫ</h1><hr>
         <table class="table table-hover table-dark">
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">Наименование</th>
                        <th scope="col">Дата поставки</th>
                        <th scope="col">Снаряжено</th>
                    </tr>

                   <#list products as product>
                   <#list amounts as amount>
                   <tr>
                       <th>${product.id}</th>
                       <th>${product.title}</th>
                       <th>${product.dateOfAddToBase}</th>
                       <th>${amount}</th>
                  </tr>
                    <#else>
                   <h3>Изделий нет</h3>
               </#list>
               </#list>
               </table>
               <hr>
                   <a class="btn btn-dark mt-3 mb-3" style="text-align: center; width: 100%"
                      data-toggle="collapse" href="#collapseExample" role="button"
                      aria-expanded="true" aria-controls="collapseExample">
                       Добавить новое изделие
                   </a>
                   <div class="collapse mb-3" id="collapseExample" style="">
                       <form action="/invoice-products/add/${akt.id}" method="post" enctype="multipart/form-data">
                           <div class="form-group">
                               <label for="invoiceTitle">Наименование</label>
                               <input type="text" required class="form-control"
                                      id="invoiceTitle" name="invoiceTitle">
                   </div>
                                 <div class="form-group">
                                  <label for="productAmount">Снаряжено</label>
                                  <div class="input-group mb-3">
                                      <input type="number" required class="form-control"
                                      id="productAmount" name="productAmount">
                                  </div>
                              </div>
                    </div>
         <input type="hidden" name="_csrf" value="${_csrf.token}"/>

<button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
   </form>
           </@t.template>
           </@t.template>