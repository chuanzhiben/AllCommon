package cn.dayu.slmap.map.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.esri.android.map.Layer;
import com.esri.android.map.MapView;
import com.esri.core.geometry.GeometryEngine;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.SpatialReference;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.dayu.slmap.R;
import cn.dayu.slmap.common.ConStant;
import cn.dayu.slmap.map.google.GoogleFactory;
import cn.dayu.slmap.map.google.GoogleMapLayer;
import cn.dayu.slmap.map.google.GoogleMapLayerTypes;
import cn.dayu.slmap.map.tianditu.LayerInfoFactory;
import cn.dayu.slmap.map.tianditu.TianDiTuLayer;
import cn.dayu.slmap.map.tianditu.TianDiTuLayerTypes;

public class ArcgisMapFragment extends Fragment {
    @Bind(R.id.map)
    MapView mMapView;
    @Bind(R.id.btn_tianditu)
    Button btnTianditu;
    @Bind(R.id.btn_google)
    Button btnGoogle;
    TianDiTuLayer t_vector_Layer, t_imge_layer, t_terrain_layer;
    TianDiTuLayer t_vectora_Layer, t_imgea_layer, t_terraina_layer;
    GoogleMapLayer g_imge_layer, g_vector_Layer, g_terrain_Layer, g_annotation_Layer;
    Layer mapLayer, annotationLayer;
    View v;
    SpatialReference mSR;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_arcgismap, null);
        initView();
        addlayer();
        ButterKnife.bind(this, v);
        return v;
    }

    private void initView() {
        mMapView = (MapView) v.findViewById(R.id.map);
        mSR = SpatialReference.create(GoogleFactory.SRID_MERCATOR);
        Point p = GeometryEngine.project(ConStant.locx, ConStant.locy, mSR);
        mMapView.zoomToResolution(p, ConStant.Rzoom);
        mMapView.setMapBackground(0x000000, 0xcccccc, 10, 1);
    }

    private void addlayer() {
        t_vector_Layer = new TianDiTuLayer(TianDiTuLayerTypes.TIANDITU_VECTOR_MERCATOR);
        t_imge_layer = new TianDiTuLayer(TianDiTuLayerTypes.TIANDITU_IMAGE_MERCATOR);
        t_terrain_layer = new TianDiTuLayer(TianDiTuLayerTypes.TIANDITU_TERRAIN_MERCATOR);
        t_vectora_Layer = new TianDiTuLayer(TianDiTuLayerTypes.TIANDITU_VECTOR_ANNOTATION_CHINESE_MERCATOR);
        t_imgea_layer = new TianDiTuLayer(TianDiTuLayerTypes.TIANDITU_IMAGE_ANNOTATION_CHINESE_MERCATOR);
        t_terraina_layer = new TianDiTuLayer(TianDiTuLayerTypes.TIANDITU_TERRAIN_ANNOTATION_CHINESE_MERCATOR);
        g_vector_Layer = new GoogleMapLayer(GoogleMapLayerTypes.GOOGLE_VECTOR_MAP);
        g_imge_layer = new GoogleMapLayer(GoogleMapLayerTypes.GOOGLE_IMAGE_MAP);
        g_terrain_Layer = new GoogleMapLayer(GoogleMapLayerTypes.GOOGLE_TERRAIN_MAP);
        g_annotation_Layer = new GoogleMapLayer(GoogleMapLayerTypes.GOOGLE_ANNOTATION_MAP);
        mapLayer = t_imge_layer;
        annotationLayer = t_imgea_layer;
        mMapView.addLayer(mapLayer);
        mMapView.addLayer(annotationLayer);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.btn_tianditu, R.id.btn_google})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_tianditu:
                mMapView.removeLayer(mapLayer);
                mMapView.removeLayer(annotationLayer);
                mapLayer = t_vector_Layer;
                annotationLayer = t_vectora_Layer;
                mMapView.addLayer(mapLayer);
                mMapView.addLayer(annotationLayer);
                break;
            case R.id.btn_google:
                this.mMapView.removeLayer(mapLayer);
                this.mMapView.removeLayer(annotationLayer);
                mapLayer = g_imge_layer;
                annotationLayer = g_annotation_Layer;
                mMapView.addLayer(mapLayer);
                mMapView.addLayer(annotationLayer);
                break;
        }
    }
}