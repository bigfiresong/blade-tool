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
package org.springblade.core.tenant;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import org.springblade.core.tool.utils.Func;
import org.springblade.core.tool.utils.StringUtil;

/**
 * 租户信息处理器
 *
 * @author Chill
 */
@Slf4j
@AllArgsConstructor
public class BladeTenantHandler implements TenantLineHandler {

	private final BladeTenantProperties properties;

	/**
	 * 获取租户ID
	 *
	 * @return 租户ID
	 */
	@Override
	public Expression getTenantId() {
		return new StringValue(Func.toStr(TenantUtil.getTenantId(), properties.getDefaultTenantId()));
	}

	/**
	 * 获取租户字段名称
	 *
	 * @return 租户字段名称
	 */
	@Override
	public String getTenantIdColumn() {
		return properties.getColumn();
	}

	/**
	 * 过滤租户表
	 *
	 * @param tableName 表名
	 * @return 是否忽略, true:表示忽略，false:需要解析并拼接多租户条件
	 */
	@Override
	public boolean ignoreTable(String tableName) {
		if (BladeTenantHolder.isIgnore()) {
			return true;
		}
		if (TenantUtil.isIgnore()) {
			return true;
		}
		return !(
			(
				(!properties.getTables().isEmpty() && properties.getTables().contains(tableName))
					|| properties.getBladeTables().contains(tableName)
			)
				&& StringUtil.isNotBlank(TenantUtil.getTenantId())
		);
	}
}
