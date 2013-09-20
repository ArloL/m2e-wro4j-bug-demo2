package de.evosec.wro4j;


import ro.isdc.wro.extensions.processor.css.LessCssProcessor;
import ro.isdc.wro.extensions.processor.css.YUICssCompressorProcessor;
import ro.isdc.wro.manager.factory.standalone.DefaultStandaloneContextAwareManagerFactory;
import ro.isdc.wro.model.resource.processor.factory.ProcessorsFactory;
import ro.isdc.wro.model.resource.processor.factory.SimpleProcessorsFactory;
import ro.isdc.wro.model.resource.processor.impl.css.LessCssImportPreProcessor;

public class LessWroManagerFactory extends
        DefaultStandaloneContextAwareManagerFactory {

	public LessWroManagerFactory() {
		setNamingStrategy(new CacheHashEncoderNamingStrategy());
	}

	@Override
	protected ProcessorsFactory newProcessorsFactory() {
		SimpleProcessorsFactory result = new SimpleProcessorsFactory();
		result.addPreProcessor(new LessCssImportPreProcessor());
		result.addPreProcessor(new LessCssProcessor());
		result.addPreProcessor(new YUICssCompressorProcessor());
		return result;
	}
}
