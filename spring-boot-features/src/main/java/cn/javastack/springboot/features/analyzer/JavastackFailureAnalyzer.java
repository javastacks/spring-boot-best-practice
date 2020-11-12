package cn.javastack.springboot.features.analyzer;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

/**
 * 来源微信公众号：Java技术栈
 */
public class JavastackFailureAnalyzer extends AbstractFailureAnalyzer<JavastackException> {

	@Override
	protected FailureAnalysis analyze(Throwable rootFailure, JavastackException cause) {
		return new FailureAnalysis("Java技术栈发生异常了……",
				"赶快去检查一下吧！",
				cause);
	}

}