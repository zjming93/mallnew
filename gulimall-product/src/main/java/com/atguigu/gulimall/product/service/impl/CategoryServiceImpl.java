package com.atguigu.gulimall.product.service.impl;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;
import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {

        List<CategoryEntity> categoryList = baseMapper.selectList(null);

        List<CategoryEntity> categoryDTOList = new ArrayList<>();

        //查询所有父类目录
        for (CategoryEntity categoryEntity : categoryList) {
            if (categoryEntity.getParentCid() == 0) {
                categoryDTOList.add(categoryEntity);
            }
        }
        Collections.sort(categoryDTOList, (o1, o2) -> {
            return o1.getSort() - o2.getSort();
        });
        //查询子目录
        getChildrens(categoryDTOList, categoryList);

        return categoryDTOList;
    }

    public void getChildrens(List<CategoryEntity> categoryDTOList, List<CategoryEntity> categoryEntities) {


        //遍历list
        for (CategoryEntity categoryEntity : categoryDTOList) {

            List<CategoryEntity> subCategoryVoList = new ArrayList<>();
            for (CategoryEntity entity : categoryEntities) {
                if (categoryEntity.getCatId().equals(entity.getParentCid())) {
                    subCategoryVoList.add(entity);
                }
            }
            Collections.sort(subCategoryVoList, new Comparator<CategoryEntity>() {
                @Override
                public int compare(CategoryEntity o1, CategoryEntity o2) {
                    if (o1.getSort() == null) {
                        return (o2.getSort() == null) ? 0 : -1;
                    }
                    if (o2.getSort() == null) {
                        return 1;
                    }
                    return o1.getSort() - o2.getSort();
                }
            });

            categoryEntity.setChildren(subCategoryVoList);            //递归调用
            getChildrens(subCategoryVoList, categoryEntities);

        }

    }

}