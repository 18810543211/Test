package doctorsay.izx.com.test.ui.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import doctorsay.izx.com.test.R;
import doctorsay.izx.com.test.ui.adapter.WaterfallDemoAdapter;

/**
 * Created by sujie on 2018/6/7.
 */

public class WaterfallDemoActivity extends AppCompatActivity {

    private RecyclerView rvWaterfallDemo;
    private WaterfallDemoAdapter mWaterfallDemoAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterfall);
        initView();
    }

    private void initView() {
        rvWaterfallDemo = findViewById(R.id.rvWaterfallDemo);
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);//定义瀑布流管理器，第一个参数是列数，第二个是方向。
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);//不设置的话，图片闪烁错位，有可能有整列错位的情况。
        rvWaterfallDemo.setHasFixedSize(true);
        rvWaterfallDemo.setLayoutManager(layoutManager);
        mWaterfallDemoAdapter = new WaterfallDemoAdapter(getData());
        rvWaterfallDemo.setAdapter(mWaterfallDemoAdapter);
    }

    private List<String> getData() {
        List<String> stringList = new ArrayList<>();
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897021&di=2be26640462fe8134a12de4e81a870b3&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0117e2571b8b246ac72538120dd8a4.jpg%401280w_1l_2o_100sh.jpg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897021&di=d4d94c66e11c75676fde9b653d1b880d&imgtype=0&src=http%3A%2F%2Fp2.gexing.com%2FG1%2FM00%2F14%2F03%2FrBACE1aTbCCSTsY5AAEIjDXspWQ96.jpeg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897020&di=111b98ad2fd50ff7d70cdbf67ae30965&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F018c3d59ac137da801211d25932cbd.jpg%401280w_1l_2o_100sh.png");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897020&di=d0269aa48d58787356b3dd2a526d9f35&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01635d571ed29832f875a3994c7836.png%40900w_1l_2o_100sh.jpg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897019&di=ae7a073fc96bceb0ea7b78169feb77ad&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F140714%2F234975-140G4155Z571.jpg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897016&di=94fe2a6aa5aef04fd3c39c21dcb40b8f&imgtype=0&src=http%3A%2F%2Fimg07.tooopen.com%2Fimages%2F20170301%2Ftooopen_sy_200052155387.jpg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349984316&di=7a7b866dad7c6d3cbe34b2396581b4e1&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F019f4e57207bc432f875a3990cbb6b.PNG%401280w_1l_2o_100sh.png");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897021&di=2be26640462fe8134a12de4e81a870b3&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0117e2571b8b246ac72538120dd8a4.jpg%401280w_1l_2o_100sh.jpg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897021&di=d4d94c66e11c75676fde9b653d1b880d&imgtype=0&src=http%3A%2F%2Fp2.gexing.com%2FG1%2FM00%2F14%2F03%2FrBACE1aTbCCSTsY5AAEIjDXspWQ96.jpeg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897020&di=111b98ad2fd50ff7d70cdbf67ae30965&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F018c3d59ac137da801211d25932cbd.jpg%401280w_1l_2o_100sh.png");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897020&di=d0269aa48d58787356b3dd2a526d9f35&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01635d571ed29832f875a3994c7836.png%40900w_1l_2o_100sh.jpg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897019&di=ae7a073fc96bceb0ea7b78169feb77ad&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F140714%2F234975-140G4155Z571.jpg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897016&di=94fe2a6aa5aef04fd3c39c21dcb40b8f&imgtype=0&src=http%3A%2F%2Fimg07.tooopen.com%2Fimages%2F20170301%2Ftooopen_sy_200052155387.jpg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349984316&di=7a7b866dad7c6d3cbe34b2396581b4e1&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F019f4e57207bc432f875a3990cbb6b.PNG%401280w_1l_2o_100sh.png");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897021&di=2be26640462fe8134a12de4e81a870b3&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0117e2571b8b246ac72538120dd8a4.jpg%401280w_1l_2o_100sh.jpg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897021&di=d4d94c66e11c75676fde9b653d1b880d&imgtype=0&src=http%3A%2F%2Fp2.gexing.com%2FG1%2FM00%2F14%2F03%2FrBACE1aTbCCSTsY5AAEIjDXspWQ96.jpeg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897020&di=111b98ad2fd50ff7d70cdbf67ae30965&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F018c3d59ac137da801211d25932cbd.jpg%401280w_1l_2o_100sh.png");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897020&di=d0269aa48d58787356b3dd2a526d9f35&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01635d571ed29832f875a3994c7836.png%40900w_1l_2o_100sh.jpg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897019&di=ae7a073fc96bceb0ea7b78169feb77ad&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F140714%2F234975-140G4155Z571.jpg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897016&di=94fe2a6aa5aef04fd3c39c21dcb40b8f&imgtype=0&src=http%3A%2F%2Fimg07.tooopen.com%2Fimages%2F20170301%2Ftooopen_sy_200052155387.jpg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349984316&di=7a7b866dad7c6d3cbe34b2396581b4e1&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F019f4e57207bc432f875a3990cbb6b.PNG%401280w_1l_2o_100sh.png");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897021&di=2be26640462fe8134a12de4e81a870b3&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0117e2571b8b246ac72538120dd8a4.jpg%401280w_1l_2o_100sh.jpg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897021&di=d4d94c66e11c75676fde9b653d1b880d&imgtype=0&src=http%3A%2F%2Fp2.gexing.com%2FG1%2FM00%2F14%2F03%2FrBACE1aTbCCSTsY5AAEIjDXspWQ96.jpeg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897020&di=111b98ad2fd50ff7d70cdbf67ae30965&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F018c3d59ac137da801211d25932cbd.jpg%401280w_1l_2o_100sh.png");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897020&di=d0269aa48d58787356b3dd2a526d9f35&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01635d571ed29832f875a3994c7836.png%40900w_1l_2o_100sh.jpg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897019&di=ae7a073fc96bceb0ea7b78169feb77ad&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F140714%2F234975-140G4155Z571.jpg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349897016&di=94fe2a6aa5aef04fd3c39c21dcb40b8f&imgtype=0&src=http%3A%2F%2Fimg07.tooopen.com%2Fimages%2F20170301%2Ftooopen_sy_200052155387.jpg");
        stringList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528349984316&di=7a7b866dad7c6d3cbe34b2396581b4e1&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F019f4e57207bc432f875a3990cbb6b.PNG%401280w_1l_2o_100sh.png");
        return stringList;
    }
}
