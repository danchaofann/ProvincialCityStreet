package com.example.provincialcitystreet.adapter;

import android.graphics.Color;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.provincialcitystreet.AddressBean;
import com.example.provincialcitystreet.R;

import java.util.List;

public class CityAdapter extends BaseQuickAdapter<AddressBean.CityBean, BaseViewHolder> {
    public CityAdapter(int layoutResId, @Nullable List<AddressBean.CityBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AddressBean.CityBean item) {
        helper.setText(R.id.textview, item.getName());
        helper.setTextColor(R.id.textview, item.isStatus() ? Color.parseColor("#3B59DB") : Color.parseColor("#444444"));
    }

}
