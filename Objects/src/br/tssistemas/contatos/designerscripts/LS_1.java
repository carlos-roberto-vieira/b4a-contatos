package br.tssistemas.contatos.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_1{

public static void LS_320x480_1(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 3;BA.debugLine="ImageView1.Visible=False"[1/320x480,scale=1]
views.get("imageview1").vw.setVisible(BA.parseBoolean("false"));
//BA.debugLineNum = 4;BA.debugLine="EditText1.Visible=False"[1/320x480,scale=1]
views.get("edittext1").vw.setVisible(BA.parseBoolean("false"));
//BA.debugLineNum = 6;BA.debugLine="btImportar.Left = 10%x"[1/320x480,scale=1]
views.get("btimportar").vw.setLeft((int)((10d / 100 * width)));
//BA.debugLineNum = 7;BA.debugLine="btImportar.Width = 80%x"[1/320x480,scale=1]
views.get("btimportar").vw.setWidth((int)((80d / 100 * width)));
//BA.debugLineNum = 8;BA.debugLine="btImportar.Top  = 0%y"[1/320x480,scale=1]
views.get("btimportar").vw.setTop((int)((0d / 100 * height)));
//BA.debugLineNum = 9;BA.debugLine="btImportar.Height = 10%y"[1/320x480,scale=1]
views.get("btimportar").vw.setHeight((int)((10d / 100 * height)));
//BA.debugLineNum = 16;BA.debugLine="btExcluir.Left = 35%x"[1/320x480,scale=1]
views.get("btexcluir").vw.setLeft((int)((35d / 100 * width)));
//BA.debugLineNum = 17;BA.debugLine="btExcluir.Top = 90%y"[1/320x480,scale=1]
views.get("btexcluir").vw.setTop((int)((90d / 100 * height)));
//BA.debugLineNum = 18;BA.debugLine="btExcluir.Width = 30%x"[1/320x480,scale=1]
views.get("btexcluir").vw.setWidth((int)((30d / 100 * width)));
//BA.debugLineNum = 19;BA.debugLine="btExcluir.Height = btImportar.Height"[1/320x480,scale=1]
views.get("btexcluir").vw.setHeight((int)((views.get("btimportar").vw.getHeight())));
//BA.debugLineNum = 21;BA.debugLine="btAdicionar.Left =70%x"[1/320x480,scale=1]
views.get("btadicionar").vw.setLeft((int)((70d / 100 * width)));
//BA.debugLineNum = 22;BA.debugLine="btAdicionar.Top = 90%y"[1/320x480,scale=1]
views.get("btadicionar").vw.setTop((int)((90d / 100 * height)));
//BA.debugLineNum = 23;BA.debugLine="btAdicionar.Width = 30%x"[1/320x480,scale=1]
views.get("btadicionar").vw.setWidth((int)((30d / 100 * width)));
//BA.debugLineNum = 24;BA.debugLine="btAdicionar.Height = btImportar.Height"[1/320x480,scale=1]
views.get("btadicionar").vw.setHeight((int)((views.get("btimportar").vw.getHeight())));
//BA.debugLineNum = 27;BA.debugLine="btExcluirImportados.Top = btExcluir.Top"[1/320x480,scale=1]
views.get("btexcluirimportados").vw.setTop((int)((views.get("btexcluir").vw.getTop())));
//BA.debugLineNum = 28;BA.debugLine="btExcluirImportados.Left = 1%x"[1/320x480,scale=1]
views.get("btexcluirimportados").vw.setLeft((int)((1d / 100 * width)));
//BA.debugLineNum = 29;BA.debugLine="btExcluirImportados.Height = btImportar.Height"[1/320x480,scale=1]
views.get("btexcluirimportados").vw.setHeight((int)((views.get("btimportar").vw.getHeight())));
//BA.debugLineNum = 30;BA.debugLine="btExcluirImportados.Width = 30%x"[1/320x480,scale=1]
views.get("btexcluirimportados").vw.setWidth((int)((30d / 100 * width)));
//BA.debugLineNum = 33;BA.debugLine="ImageView1.Top = 10%y"[1/320x480,scale=1]
views.get("imageview1").vw.setTop((int)((10d / 100 * height)));
//BA.debugLineNum = 34;BA.debugLine="ImageView1.Left = 2%x"[1/320x480,scale=1]
views.get("imageview1").vw.setLeft((int)((2d / 100 * width)));
//BA.debugLineNum = 35;BA.debugLine="ImageView1.Height = 20%y"[1/320x480,scale=1]
views.get("imageview1").vw.setHeight((int)((20d / 100 * height)));
//BA.debugLineNum = 36;BA.debugLine="ImageView1.Width = 30%x"[1/320x480,scale=1]
views.get("imageview1").vw.setWidth((int)((30d / 100 * width)));
//BA.debugLineNum = 38;BA.debugLine="EditText1.Top = 10%y"[1/320x480,scale=1]
views.get("edittext1").vw.setTop((int)((10d / 100 * height)));
//BA.debugLineNum = 39;BA.debugLine="EditText1.Left = 35%x"[1/320x480,scale=1]
views.get("edittext1").vw.setLeft((int)((35d / 100 * width)));
//BA.debugLineNum = 42;BA.debugLine="CLV1.Left = 0"[1/320x480,scale=1]
views.get("clv1").vw.setLeft((int)(0d));
//BA.debugLineNum = 43;BA.debugLine="CLV1.Width = 100%x"[1/320x480,scale=1]
views.get("clv1").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 44;BA.debugLine="CLV1.Top = 10%y"[1/320x480,scale=1]
views.get("clv1").vw.setTop((int)((10d / 100 * height)));
//BA.debugLineNum = 45;BA.debugLine="CLV1.Height = 78%y"[1/320x480,scale=1]
views.get("clv1").vw.setHeight((int)((78d / 100 * height)));
//BA.debugLineNum = 48;BA.debugLine="pac.Top = 0%y"[1/320x480,scale=1]
views.get("pac").vw.setTop((int)((0d / 100 * height)));
//BA.debugLineNum = 49;BA.debugLine="pac.Left = 0%x"[1/320x480,scale=1]
views.get("pac").vw.setLeft((int)((0d / 100 * width)));
//BA.debugLineNum = 50;BA.debugLine="pac.Height = 100%y"[1/320x480,scale=1]
views.get("pac").vw.setHeight((int)((100d / 100 * height)));
//BA.debugLineNum = 51;BA.debugLine="pac.Width = 100%x"[1/320x480,scale=1]
views.get("pac").vw.setWidth((int)((100d / 100 * width)));

}
public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);

}
}