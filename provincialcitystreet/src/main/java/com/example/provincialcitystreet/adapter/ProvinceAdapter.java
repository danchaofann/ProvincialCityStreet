package com.example.provincialcitystreet.adapter;

import android.graphics.Color;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.provincialcitystreet.AddressBean;
import com.example.provincialcitystreet.R;

import java.util.List;

public class ProvinceAdapter extends BaseQuickAdapter<AddressBean, BaseViewHolder> {
public ProvinceAdapter(int layoutResId, @Nullable List<AddressBean> data) {
        super(layoutResId, data);
        }

@Override
protected void convert(BaseViewHolder helper, AddressBean item) {
        helper.setText(R.id.textview, item.getName());
        helper.setTextColor(R.id.textview, item.isStatus() ? Color.parseColor("#3B59DB") : Color.parseColor("#444444"));
        }


}
