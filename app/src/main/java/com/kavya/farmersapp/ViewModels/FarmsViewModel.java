package com.kavya.farmersapp.ViewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.kavya.farmersapp.Models.Farm;

import java.util.ArrayList;
import java.util.List;

public class FarmsViewModel extends ViewModel {

    private MutableLiveData<List<Farm>> farm;


    public MutableLiveData<List<Farm>> getFarm() {
        if(farm ==  null){
            farm = new MutableLiveData<>();
            farm.postValue(getFarmList());
        }
        return farm;
    }

    public List<Farm> getFarmList(){
        List<Farm> farmList = new ArrayList<>();
        farmList.add(new Farm("abc","zuz","raj","23-14-1,verrayacolony sc","Rice"));
        farmList.add(new Farm("adfas","sd","ravi","23-14-1,verrayacolony sc","Wheat"));
        farmList.add(new Farm("asd","zasduz","rama rao","23-14-1,verrayacolony sc","Paddy"));
        farmList.add(new Farm("asdbc","adsa","venkana","23-14-1,verrayacolony sc","Varri"));
        return  farmList;
    }

}
