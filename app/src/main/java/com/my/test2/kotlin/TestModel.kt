package  com.dsf.vms

import android.app.Activity
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.dsf.dsfwarehouse.base.BaseHaveFooterAdapter
import com.dsf.vms.base.MyBaseModel
import com.dsf.vms.databinding.ActivityTestBinding
import com.dsf.vms.model.NormalTitleModel
import com.dsf.vms.utils.ToastUtil

class TestModel  constructor(binding: ActivityTestBinding, context: Activity) :
    MyBaseModel<ActivityTestBinding>(binding, context) {
    private var testAdapter: TestAdapter?=null
    private var titleModel:NormalTitleModel?=null
    init {
        binding.tvTest.setText("点我")
        titleModel= NormalTitleModel(binding.title,context);
        titleModel?.setClickAction(object:NormalTitleModel.ClickAction{
            override fun onClick(){
                ToastUtil.showToast(context,"点击了action");
            }
        })
        titleModel?.setRightTextIcon(R.mipmap.btn_back_white);
        titleModel?.setRightText("点我")
        titleModel?.setTitleText("标题哦")
        var data:ArrayList<String> = ArrayList();
        for(i in 1..10){
            data.add("item"+i);
        }
        testAdapter= TestAdapter(context,data);
        testAdapter?.onItemClick=object:BaseHaveFooterAdapter.OnItemClick{
            override fun onClick(view: View, position: Int) {
                ToastUtil.showToast(context,"点击了第"+position)
            }

            override fun onFooterClick(view: View) {
                ToastUtil.showToast(context,"点击了底部")
            }

        }
        binding.rv.setOnClickListener(View.OnClickListener {

        })
        binding.rv.layoutManager =LinearLayoutManager(context);
        binding.rv.adapter =testAdapter;

        bindListener(binding.tvTest)

    }

    override fun onClick(v: View?) {
        if(v!!.id==R.id.tv_test){
            ToastUtil.showToast(context,"点击了哦");
        }
    }

}