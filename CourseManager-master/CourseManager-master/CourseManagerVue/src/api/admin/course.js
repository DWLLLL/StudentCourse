import * as ajax from "../../common/ajax";

export const get = id => ajax.get("/admin/course/" + id);

export const create = entity => ajax.post("/admin/course", entity);

export const deleteItem = id => ajax.pureDelete("/admin/course/" + id);

export const update = entity => ajax.put("/admin/course", entity);

export const getPageCount = (departmentName, teacherName, name) =>
  ajax.get("/admin/course/page/count", {
    departmentName: departmentName,
    teacherName: teacherName,
    name: name
  });

export const getPage = (index, departmentName, teacherName, name) =>
  ajax.get("/admin/course/page/" + index, {
    departmentName: departmentName,
    teacherName: teacherName,
    name: name
  });

export const listName = () => ajax.pureGet("/admin/course/names");

export const pageSize = 20;
