package com.briup.estore.mapper.ex;

import java.util.List;

import com.briup.estore.bean.ex.CategoryEx;

public interface CategoryMapperEx {
   List<CategoryEx> selectOnceCategories();
   List<CategoryEx> selectCategories();
   List<CategoryEx> selectCategories1();
}