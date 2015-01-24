package org.nem.ncc.services;

import org.nem.core.model.Address;
import org.nem.ncc.controller.viewmodels.AccountViewModel;
import org.nem.ncc.wallet.WalletAccount;

/**
 * Helper class that is able to map various account representations to an AccountViewModel.
 */
public class AccountMapper {
	private final AccountMetaDataPairLookup accountLookup;

	/**
	 * Creates a wallet mapper.
	 *
	 * @param accountLookup The account lookup.
	 */
	public AccountMapper(final AccountMetaDataPairLookup accountLookup) {
		this.accountLookup = accountLookup;
	}

	/**
	 * Converts the specified model to a view model.
	 *
	 * @param account The model.
	 * @return The view model.
	 */
	public AccountViewModel toViewModel(final WalletAccount account) {
		return this.toViewModel(account.getAddress());
	}

	/**
	 * Creates a view model for the account with the specified address.
	 *
	 * @param address The address.
	 * @return The view model.
	 */
	public AccountViewModel toViewModel(final Address address) {
		return new AccountViewModel(this.accountLookup.findPairByAddress(address));
	}
}
