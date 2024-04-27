/**
 * Author : PhearunPhin
 * Date : 4/4/2024
 */

package phearun.thds_backend.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import phearun.thds_backend.exception.ApiException;
import phearun.thds_backend.model.SubCategory;

import phearun.thds_backend.repository.SubCategoryRepository;
import phearun.thds_backend.service.SubCategoryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;


    @Override
    public SubCategory save(SubCategory entity) {
        return subCategoryRepository.save(entity);
    }

    @Override
    public SubCategory getById(Long id) {

        System.out.println("id= ========"+ subCategoryRepository.findById(id));
        return subCategoryRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, String.format("SubCategory not found for id=%d", id)));
    }
//
    @Override
    public List<SubCategory> getSubCategoryByCategoryId(Long cateId) {

       // System.out.println(subCategoryRepository.findSubCategoriesByCateId(id));

        System.out.println("kkkkkkkkkkkkk");

        return subCategoryRepository.findSubCategoriesByCategory_Id(cateId);
    }
//
//
//    @Override
//    public SubCategory update(Long id, SubCategory SubCategory) {
//        SubCategory target = getById(id);
//
//        BeanUtils.copyProperties(SubCategory, target, "id");
//
//        return subCategoryRepository.save(target);
//    }
//
    @Override
    public List<SubCategory> getSubCategories() {
        return subCategoryRepository.findAll();
    }
//
    @Override
    public void delete(Long id) {
        subCategoryRepository.deleteById(id);
    }
}
