//package com.example.SecKillSys;
//
//import org.apache.jmeter.config.Arguments;
//import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
//import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
//import org.apache.jmeter.samplers.SampleResult;
//
///**
// * @author: rich
// * @date: 2022/10/24 19:35
// * @description:
// */
//public class P1SignTest extends AbstractJavaSamplerClient {
//
//    /**
//     * 把测试的一些默认数据在程序运行前显示到JMeter客户端，
//     * 如果设置类下面的参数则可以再JMeter中赋值。
//     * @return
//     */
//    @Override
//    public Arguments getDefaultParameters() {
//        Arguments params = new Arguments();
//        params.addArgument("certId", "");
//        params.addArgument("original", "");
//        return params;
//    }
//
//    /**
//     * 测试执行的循环体，根据线程数和循环次数的不同可执行多次，
//     * 在这里面调用你的业务代码即可
//     * @param context
//     * @return
//     */
//    @Override
//    public SampleResult runTest(JavaSamplerContext context) {
//        SampleResult sampleResult = new SampleResult();
//        // 从JMeter中获取参数
//        String certId = context.getParameter("certId");
//        String original = context.getParameter("original");
//
//        // 计时开始
//        sampleResult.sampleStart();
//
//        //测试方法
//        try {
//            // 业务代码在这里面调用，你需要对那个方法进行压力测试就在这里面调用即可。
//
//            //将结果写入结果树：在jmeter的监听器-查看结果树时即可查看返回结果
//            sampleResult.setResponseData("执行结果是：" + result, null);
//            sampleResult.setDataType(SampleResult.TEXT);
//            sampleResult.setSuccessful(true);
//        } catch (Exception e) {
//            sampleResult.setSuccessful(false);
//            e.printStackTrace();
//        }
//        return sampleResult;
//    }
//
//    /**
//     * 测试的时候用，打包的时候注释掉即可
//     *
//     **/
//    public static void main(String[] args) {
//        Arguments params = new Arguments();
//        params.addArgument("certId", "60c895631462c37c35e951bb");
//        params.addArgument("original", "签名数据");
//
//        JavaSamplerContext context = new JavaSamplerContext(params);
//        // 业务类
//        P1SignTest p1SignTest = new P1SignTest();
//        p1SignTest.setupTest(context);
//        p1SignTest.runTest(context);
//        p1SignTest.teardownTest(context);
//    }
//
//}