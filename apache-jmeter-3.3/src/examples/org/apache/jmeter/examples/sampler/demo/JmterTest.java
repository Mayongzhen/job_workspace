package org.apache.jmeter.examples.sampler.demo;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.engine.JMeterEngine;
import org.apache.jmeter.engine.JMeterEngineException;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.control.Header;
import org.apache.jmeter.protocol.http.control.HeaderManager;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.protocol.http.util.HTTPArgument;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.samplers.SampleSaveConfiguration;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.testelement.property.*;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import org.apache.jorphan.collections.ListedHashTree;
import org.apache.jmeter.threads.ThreadGroup;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;
public class JmterTest {
        static{
            {
                JMeterUtils.setJMeterHome(new File("").getAbsolutePath());
                JMeterUtils.loadJMeterProperties(new File("src/main/resources/jmeter/jmeter.properties").getAbsolutePath());
                JMeterUtils.setProperty("saveservice_properties", "src/main/resources/jmeter/saveservice.properties");
                JMeterUtils.setProperty("user_properties", "src/main/resources/jmeter/user.properties");
                JMeterUtils.setProperty("upgrade_properties", "src/main/resources/jmeter/upgrade.properties");
                JMeterUtils.setProperty("system_properties", "src/main/resources/jmeter/system.properties");
//            JMeterUtils.setProperty("proxy.cert.directory", new File("").getAbsolutePath());
                JMeterUtils.setLocale(Locale.CHINESE);
                JMeterUtils.initLocale();

            }
        }
        @Test
        public  void test() throws JMeterEngineException, IOException {
            File file = new File("D:\\jmeter_jmx\\HTTP Request.jmx");
            HashTree hashTree = SaveService.loadTree(file);
            JMeterEngine engine = new StandardJMeterEngine();
            engine.configure(hashTree);
            ((StandardJMeterEngine) engine).run();
        }
        @Test
        public void test04() throws IOException {
            String url = "172.16.16.58";
            String port = "8080";
            String api = "/talkplatform_teacher_consumer//v1/backend/teacher/search_limit_config?appkey=test&timestamp=1585566951&limit=6";
            String request = "{}";



            //TestPlan
            TestPlan testPlan = new TestPlan("Test Plan");
            testPlan.setFunctionalMode(false);
            testPlan.setSerialized(false);
            testPlan.setTearDownOnShutdown(true);
            testPlan.setProperty(TestElement.TEST_CLASS, TestPlan.class.getName());
            testPlan.setProperty(TestElement.GUI_CLASS,"TestPlanGui");
            testPlan.setProperty(new BooleanProperty(TestElement.ENABLED, true));
            testPlan.setProperty(new StringProperty("TestPlan.comments", ""));
            testPlan.setProperty(new StringProperty("TestPlan.user_define_classpath", ""));
            Arguments arguments = new Arguments();
            testPlan.setProperty(new TestElementProperty("TestPlan.user_defined_variables",arguments));


            ThreadGroup threadGroup = new ThreadGroup();
            threadGroup.setNumThreads(1);
            threadGroup.setRampUp(1);
            threadGroup.setDelay(0);
            threadGroup.setDuration(0);
            threadGroup.setProperty(new StringProperty(ThreadGroup.ON_SAMPLE_ERROR, "continue"));
            threadGroup.setScheduler(false);
            threadGroup.setName("Group1");
            threadGroup.setProperty(TestElement.TEST_CLASS, ThreadGroup.class.getName());
            threadGroup.setProperty(TestElement.GUI_CLASS,"ThreadGroup");
            threadGroup.setProperty(new BooleanProperty(TestElement.ENABLED, true));

            LoopController loopController = new LoopController();
            loopController.setLoops(0);
            loopController.setProperty(new BooleanProperty("LoopController.continue_forever",false));
            loopController.setProperty(new StringProperty("TestElement.gui_class","org.apache.jmeter.control.gui.LoopControlPanel"));
            loopController.setProperty(new StringProperty("TestElement.test_class","org.apache.jmeter.control.LoopController"));
            loopController.setProperty(new StringProperty("TestElement.name","Loop Controller"));
            loopController.setProperty(new StringProperty("TestElement.enabled","true"));
            loopController.setProperty(new StringProperty("LoopController.loops","1"));

            threadGroup.setProperty(new TestElementProperty("ThreadGroup.main_controller",loopController));

            HTTPSamplerProxy httpSamplerProxy = new HTTPSamplerProxy();
            Arguments HTTPsamplerArguments = new Arguments();
            HTTPArgument httpArgument = new HTTPArgument();
            httpArgument.setProperty(new BooleanProperty("HTTPArgument.always_encode",false));
            httpArgument.setProperty(new StringProperty("Argument.value", request));
            httpArgument.setProperty(new StringProperty("Argument.metadata","="));
            ArrayList<TestElementProperty> list1 = new ArrayList<>();
            list1.add(new TestElementProperty("",httpArgument));
            HTTPsamplerArguments.setProperty(new CollectionProperty("Arguments.arguments",list1));
            httpSamplerProxy.setProperty(new TestElementProperty("HTTPsampler.Arguments",HTTPsamplerArguments));
            httpSamplerProxy.setProperty(new StringProperty("HTTPSampler.domain", url));
            httpSamplerProxy.setProperty(new StringProperty("HTTPSampler.port", port));
            httpSamplerProxy.setProperty(new StringProperty("HTTPSampler.protocol", "http"));
            httpSamplerProxy.setProperty(new StringProperty("HTTPSampler.path", api));
            httpSamplerProxy.setProperty(new StringProperty("HTTPSampler.method", "POST"));
            httpSamplerProxy.setProperty(new StringProperty("HTTPSampler.contentEncoding", ""));
            httpSamplerProxy.setProperty(new BooleanProperty("HTTPSampler.follow_redirects", true));
            httpSamplerProxy.setProperty(new BooleanProperty("HTTPSampler.postBodyRaw", true));
            httpSamplerProxy.setProperty(new BooleanProperty("HTTPSampler.auto_redirects", false));
            httpSamplerProxy.setProperty(new BooleanProperty("HTTPSampler.use_keepalive", true));
            httpSamplerProxy.setProperty(new BooleanProperty("HTTPSampler.DO_MULTIPART_POST", false));
            httpSamplerProxy.setProperty(new StringProperty("TestElement.gui_class", "org.apache.jmeter.protocol.http.control.gui.HttpTestSampleGui"));
            httpSamplerProxy.setProperty(new StringProperty("TestElement.test_class", "org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy"));
            httpSamplerProxy.setProperty(new StringProperty("TestElement.name", "HTTP Request"));
            httpSamplerProxy.setProperty(new StringProperty("TestElement.enabled", "true"));
            httpSamplerProxy.setProperty(new BooleanProperty("HTTPSampler.postBodyRaw", true));
            httpSamplerProxy.setProperty(new StringProperty("HTTPSampler.embedded_url_re", ""));
            httpSamplerProxy.setProperty(new StringProperty("HTTPSampler.connect_timeout", ""));
            httpSamplerProxy.setProperty(new StringProperty("HTTPSampler.response_timeout", ""));




            ResultCollector resultCollector = new ResultCollector();
            HeaderManager headerManager = new HeaderManager();
            SampleSaveConfiguration sampleSaveConfiguration = new SampleSaveConfiguration();
            sampleSaveConfiguration.setTime(true);
            sampleSaveConfiguration.setLatency(true);
            sampleSaveConfiguration.setTimestamp(true);
            sampleSaveConfiguration.setSuccess(true);
            sampleSaveConfiguration.setLabel(true);
            sampleSaveConfiguration.setCode(true);
            sampleSaveConfiguration.setMessage(true);
            sampleSaveConfiguration.setThreadName(true);
            sampleSaveConfiguration.setDataType(true);
            sampleSaveConfiguration.setEncoding(false);
            sampleSaveConfiguration.setAssertions(true);
            sampleSaveConfiguration.setSubresults(true);
            sampleSaveConfiguration.setResponseData(false);
            sampleSaveConfiguration.setSamplerData(false);
            sampleSaveConfiguration.setAsXml(false);
            sampleSaveConfiguration.setFieldNames(true);
            sampleSaveConfiguration.setResponseHeaders(false);
            sampleSaveConfiguration.setRequestHeaders(false);
            //sampleSaveConfiguration.setAssertionResultsFailureMessage(true);  responseDataOnError
            sampleSaveConfiguration.setAssertionResultsFailureMessage(true);
            //sampleSaveConfiguration.setsserAtionsResultsToSave(0); assertionsResultsToSave
            sampleSaveConfiguration.setBytes(true);
            sampleSaveConfiguration.setSentBytes(true);
            sampleSaveConfiguration.setUrl(true);
            sampleSaveConfiguration.setThreadCounts(true);
            sampleSaveConfiguration.setIdleTime(true);
            sampleSaveConfiguration.setConnectTime(true);
            resultCollector.setProperty(new BooleanProperty("ResultCollector.error_logging",false));
            resultCollector.setProperty(new ObjectProperty("saveConfig",new SampleSaveConfiguration()));
            resultCollector.setProperty(new StringProperty("TestElement.gui_class","org.apache.jmeter.visualizers.ViewResultsFullVisualizer"));
            resultCollector.setProperty(new StringProperty("TestElement.name","View Results Tree"));
            resultCollector.setProperty(new StringProperty("TestElement.enabled","true"));
            resultCollector.setProperty(new StringProperty("filename",""));

            ArrayList<TestElementProperty> list2 = new ArrayList<>();

            Header header = new Header();
            header.setProperty(new StringProperty("Header.name","Content-Type"));
            header.setProperty(new StringProperty("Header.value","application/json"));
            TestElementProperty HeaderElement = new TestElementProperty("",header);
            list2.add(HeaderElement);
            headerManager.setProperty(new CollectionProperty("HeaderManager.headers",list2));
            headerManager.setProperty(new StringProperty("TestElement.test_class","org.apache.jmeter.protocol.http.control.HeaderManager"));
            headerManager.setProperty(new StringProperty("TestElement.name","HTTP Header Manager"));
            headerManager.setProperty(new StringProperty("TestElement.enabled","true"));
            headerManager.setProperty(new StringProperty("TestElement.gui_class","org.apache.jmeter.protocol.http.gui.HeaderPanel"));




            ListedHashTree hashTreeResultCollectorAndHeaderManager = new ListedHashTree();
            hashTreeResultCollectorAndHeaderManager.add(resultCollector);
            hashTreeResultCollectorAndHeaderManager.add(headerManager);

            ListedHashTree hashTreeHTTPSamplerProxy = new ListedHashTree();
            hashTreeHTTPSamplerProxy.add(httpSamplerProxy,hashTreeResultCollectorAndHeaderManager);

            ListedHashTree hashTreeThreadGroup = new ListedHashTree();
            hashTreeThreadGroup.add(threadGroup,hashTreeHTTPSamplerProxy);


            ListedHashTree hashTreeTestPlan = new ListedHashTree();
            hashTreeTestPlan.add(testPlan,hashTreeThreadGroup);

            //可以将生成的hashTree保存成一个jmx文件  与Jmeter自己生成的做对比
            //SaveService.saveTree(hashTreeTestPlan, new FileOutputStream("D:\\jmeter_jmx\\test.jmx"));

            JMeterEngine engine = new StandardJMeterEngine();
            //engine.configure(SaveService.loadTree(new File("D:\\jmeter_jmx\\test.jmx")));
            engine.configure(hashTreeTestPlan);
            ((StandardJMeterEngine) engine).run();
        }
    }




