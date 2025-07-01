/**
 * Copyright (c) 2018-2099, Chill Zhuang 庄骞 (bladejava@qq.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.core.report.config;

import jakarta.servlet.Filter;
import org.springblade.core.report.filter.UReportAuthFilter;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

/**
 * UReport认证配置类
 *
 * @author BladeX
 */
@Order
@AutoConfiguration
@ConditionalOnProperty(value = "report.auth", havingValue = "true", matchIfMissing = true)
public class ReportAuthConfiguration {

	@Bean
	public FilterRegistrationBean<Filter> uReportAuthFilter() {
		FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
		registration.setFilter(new UReportAuthFilter());
		registration.addUrlPatterns("/ureport/*");
		registration.setName("uReportAuthFilter");
		registration.setOrder(1);
		return registration;
	}

}
